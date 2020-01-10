package io.devfactory.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static io.devfactory.util.CommonUtils.delay;

public class Shop {

    private Random random = new Random();
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 동기 API 로 가정
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    // 비동기 API 로 가정
    public Future<Double> getPriceAsync(String product) {
        final CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                final double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();

        return futurePrice;
    }

    // 비동기 API 로 가정
    public Future<Double> getPriceSupplyAsync(String product) {
        // getPriceAsync 메서드 처럼 동작함, 근데 미세한 속도 차이는 있는듯?
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public Future<Double> getPriceException(String product) {
        return CompletableFuture.supplyAsync(() ->  calculatePriceException(product));
    }

    private double calculatePrice(String product) {
        delay(1);
        return random.nextDouble() * (product.charAt(0) + product.charAt(1));
    }

    private double calculatePriceException(String product) {
        throw new RuntimeException("calculatePriceException...");
    }

}
