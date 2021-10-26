package io.devfactory.example.modernjava.completable;

import static io.devfactory.global.util.CommonUtils.delay;
import static java.lang.String.format;

import io.devfactory.global.error.ServiceRuntimeException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

  private final Random random = new Random();
  private final String name;

  public Shop(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  // price - 동기 API 로 가정
  public double getPrice(String product) {
    return calculatePrice(product);
  }

  // price & discount - 동기 API 로 가정
  public String getPriceWithDiscount(String product) {
    final double price = calculatePrice(product);
    final DiscountCode code = DiscountCode.values()[random.nextInt(DiscountCode.values().length)];
    return format("%s:%.2f:%s", name, price, code);
  }

  // price - 비동기 API 로 가정
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

  // price - 비동기 API 로 가정
  public Future<Double> getPriceSupplyAsync(String product) {
    // getPriceAsync 메서드 처럼 동작함, 근데 첫 시작시 미세한 속도 차이는 있는듯?
    return CompletableFuture.supplyAsync(() -> calculatePrice(product));
  }

  private double calculatePrice(String product) {
    delay(1);
    return random.nextDouble() * (product.charAt(0) + product.charAt(1));
  }

  //------------------------------------------------------------------------------------------------------------------

  // price - 예외발생
  public Future<Double> getPriceException(String product) {
    return CompletableFuture.supplyAsync(() -> calculatePriceException(product));
  }

  private double calculatePriceException(String product) {
    throw new ServiceRuntimeException("calculatePriceException...");
  }

}
