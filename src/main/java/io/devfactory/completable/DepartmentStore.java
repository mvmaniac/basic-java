package io.devfactory.completable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Function;

import static java.lang.String.format;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.iterate;

public class DepartmentStore {

    private List<Shop> shops;
    private Executor executor;

    public DepartmentStore(int size) {
        // @formatter:off
        // iterate 부터 map 까지 한 사이클씩 size 만큼 실행됨
        // 1 사이클: (iterate -> limit -> map)
        this.shops = iterate(1, n -> n + 1)
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

    // 동기 처리
    public List<String> findShopPricesBlocking(String product) {
        // @formatter:off
        return shops.stream()
            .map(shop -> getPriceFormat(product, shop))
            .collect(toList());
        // @formatter:on
    }

    // 병렬 스트림으로 요청 병렬화
    public List<String> findShopPricesParallel(String product) {
        // @formatter:off
        return shops.parallelStream()
                .map(shop -> getPriceFormat(product, shop))
                .collect(toList());
        // @formatter:on
    }

    // CompletableFuture 로 비동기 호출
    public List<String> findShopPricesSupplyAsync(String product) {
        // @formatter:off
        Function<Shop, CompletableFuture<String>> supplyAsync = (shop) ->
            supplyAsync(() -> getPriceFormat(product, shop));
        // @formatter:on

        return findShopPrices(supplyAsync);
    }

    // CompletableFuture 와 Executor 로 비동기 호출
    public List<String> findShopPricesSupplyAsyncWithExecutor(String product) {
        // @formatter:off
        Function<Shop, CompletableFuture<String>> supplyAsync = (shop) ->
            supplyAsync(() -> getPriceFormat(product, shop), executor);
        // @formatter:on

        return findShopPrices(supplyAsync);
    }

    private List<String> findShopPrices(Function<Shop, CompletableFuture<String>> asyncApply) {
        // @formatter:off
        final List<CompletableFuture<String>> priceFuture = shops.stream().map(asyncApply).collect(toList());

        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(toList());
        // @formatter:on
    }

    // getPrice 메소드가 오래 걸리는 API 를 호출 했다고 가정
    private String getPriceFormat(String product, Shop shop) {
        return format("%s price is %.2f", shop.getName(), shop.getPrice(product));
    }

}
