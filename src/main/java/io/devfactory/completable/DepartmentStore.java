package io.devfactory.completable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;

public class DepartmentStore {

    private List<Shop> shops;
    private Executor executor;

    public DepartmentStore(int size) {
        // @formatter:off
        // iterate 부터 map 까지 한 사이클씩 size 만큼 실행됨
        // 1 사이클: (iterate -> limit -> map)
        shops = Stream.iterate(1, n -> n + 1)
            .limit(size)
            .map(n -> new Shop("product"+ n))
            .collect(toList());

        // 하나의 Executor 에서 사용할 스레드의 최대 개수는 100 이하로 설정하는게 바람직하다고 함
        executor = Executors.newFixedThreadPool(
            // 상점 수만큼의 스레드를 갖는 풀을 생성
            Math.min(shops.size(), 100),

            // 데몬 스레드를 포함함
            // 일반 스레드가 실행 중이면 자바 프로그램은 종료되지 않음
            // 데폰 스레드는 자바 프로그램이 종료될 때 강제로 실행이 종료될 수 있음
            r -> {
                final Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        );
        // @formatter:on
    }

    //------------------------------------------------------------------------------------------------------------------

    // price - 동기 처리
    public List<String> findShopPricesBlocking(String product) {
        // @formatter:off
        return shops.stream()
            .map(shop -> getPriceFormat(product, shop))
            .collect(toList())
        ;
        // @formatter:on
    }

    // price - 병렬 스트림으로 요청 병렬화
    // 병렬 스트름이 사용하는 스레드 풀의 크리가 고정되어 있음
    // 그래서 예제의 경우 상점 수가 늘어나면 (스레드 갯수보다 많을 경우)
    // 유연하게 대응할 수 없다.
    public List<String> findShopPricesParallel(String product) {
        // @formatter:off
        return shops.parallelStream()
            .map(shop -> getPriceFormat(product, shop))
            .collect(toList())
        ;
        // @formatter:on
    }

    // price - CompletableFuture 로 비동기 처리
    public List<String> findShopPricesSupplyAsync(String product) {
        // @formatter:off
        Function<Shop, CompletableFuture<String>> supplyAsync = (shop) ->
            supplyAsync(() -> getPriceFormat(product, shop));
        // @formatter:on

        return findShopPrices(supplyAsync);
    }

    // price - CompletableFuture 와 Executor 로 비동기 처리
    // 병렬 스트림과 달리 Executor 를 정의함으로써 스레드 풀을 조정할 수 있음
    public List<String> findShopPricesSupplyAsyncWithExecutor(String product) {
        // @formatter:off
        Function<Shop, CompletableFuture<String>> supplyAsync = (shop) ->
            supplyAsync(() -> getPriceFormat(product, shop), executor);
        // @formatter:on

        return findShopPrices(supplyAsync);
    }

    // price
    private List<String> findShopPrices(Function<Shop, CompletableFuture<String>> asyncApply) {
        // @formatter:off
        final List<CompletableFuture<String>> priceFuture = shops.stream().map(asyncApply).collect(toList());

        return priceFuture.stream()
            .map(CompletableFuture::join)
            .collect(toList())
        ;
        // @formatter:on
    }

    // getPrice 메소드가 오래 걸리는 API 를 호출 했다고 가정
    private String getPriceFormat(String product, Shop shop) {
        return format("%s price is %.2f", shop.getName(), shop.getPrice(product));
    }

    //------------------------------------------------------------------------------------------------------------------

    // price & discount - 동기 처리 (getPriceWithDiscount 1초 delay, applyDiscount 1초 delay 됨)
    public List<String> findShopPricesWithDiscount(String product) {
        // @formatter:off
        return shops.stream()
            .map(shop -> shop.getPriceWithDiscount(product))
            .map(Quote::parse)
            .map(Discount::applyDiscount)
            .collect(toList())
        ;
        // @formatter:on
    }

    // price & discount - CompletableFuture 로 비동기 처리
    // thenCompose 의 경우 리스트의 각 값들이 완료 될 때까지 기다림
    // 한 executor 스레드에서 돌아감
    public List<String> findShopPricesWithDiscountSupplyAsync(String product) {
        // @formatter:off
        final List<CompletableFuture<String>> priceFuture = findShopPricesWithDiscountStream(product).collect(toList());

        return priceFuture.stream()
            .map(CompletableFuture::join)
            .collect(toList())
        ;
        // @formatter:on
    }

    // price & discount - CompletableFuture 로 비동기 처리
    // thenAccept 의 경우 각 값들이 완료되는 대로 처리 됨
    public void printShopPricesWithDiscount(String product) {
        // @formatter:off
        long startTime = System.nanoTime();

        final var completableFutures = findShopPricesWithDiscountStream(product)
            .map(future -> future.thenAccept(s -> {
                System.out.println(format("%s (done in %d msecs)", s, (System.nanoTime() - startTime) / 1_000_000));
            }))
            .toArray(CompletableFuture[]::new)
        ;
        // @formatter:on

        CompletableFuture.allOf(completableFutures).join();
        System.out.println(format("All shops have row responded in %d msecs", (System.nanoTime() - startTime) / 1_000_000));
    }

    // price & discount
    private Stream<CompletableFuture<String>> findShopPricesWithDiscountStream(String product) {
        // @formatter:off
        return shops.stream()
            .map(shop -> supplyAsync(() -> shop.getPriceWithDiscount(product), executor))
            .map(future -> future.thenApply(Quote::parse))
            .map(future -> future.thenCompose(quote ->
                supplyAsync(() -> Discount.applyDiscount(quote), executor)
            ))
        ;
        // @formatter:on
    }

    //------------------------------------------------------------------------------------------------------------------

    // price & exchange - CompletableFuture 로 비동기 처리 (exchange)
    // thenCombine 의 경우 thenCompose 와 다르게 두개의 executor 스레드가 실행됨, 그리고 합쳐짐
    public List<String> findShopPricesWithExchangeSupplyAsync(String product) {
        // @formatter:off
        final List<CompletableFuture<String>> priceFutureInUSD = shops.stream()
                // 제품가격 정보를 요청하는 첫번째 태스크를 생성
                .map(shop -> supplyAsync(() -> shop.getPrice(product)))

                .map(future -> future.thenCombine(
                    // EUR, USD 의 환율 정보를 요청하는 독립적인 두 번째 태스크를 생성
                    supplyAsync(() -> Exchange.getRate(ExchangeMoney.EUR, ExchangeMoney.USD))

                        // 환전 서비스가 2초 안에 결과를 제공하지 않으면 기본 환율값 을 사용
                        .completeOnTimeout(Exchange.DEFAULT_RATE, 2, TimeUnit.SECONDS),

                    // 두 결과를 곱해서 가격과 환율 정보를 합침
                    (price, rate) -> format("(%.2f * %.2f) = %.2f", price, rate, price * rate))

                    // 3초 뒤에 작업이 완료되지 않으면 TimeOutException 을 발생
                    // 에러를 확인하려면 completeOnTimeout 의 timeout 값을 더 높게 주어야 함
                    .orTimeout(3, TimeUnit.SECONDS)
                )
                .collect(toList())
            ;

        return priceFutureInUSD.stream()
            .map(CompletableFuture::join)
            .collect(toList())
        ;
        // @formatter:on
    }

}
