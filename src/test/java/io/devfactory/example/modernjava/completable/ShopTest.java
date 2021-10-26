package io.devfactory.example.modernjava.completable;

import static io.devfactory.global.util.CommonUtils.millisToSeconds;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.util.StopWatch;

@SuppressWarnings("squid:S2699")
@Slf4j
@TestInstance(PER_CLASS)
class ShopTest {

  private StopWatch stopWatch;
  private Shop bestShop;

  @BeforeAll
  void setUp() {
    stopWatch = new StopWatch("ShopTest");
    bestShop = new Shop("BestShop");
  }

  @DisplayName("getPriceXXX 테스트")
  @RepeatedTest(value = 2, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  void getPriceXXX_테스트() {
    executeGetPrice(bestShop::getPriceAsync, "product is Async");
    log.debug("[dev] ---------------------------------------------------");
    executeGetPrice(bestShop::getPriceSupplyAsync, "product is SupplyAsync");
  }

  @DisplayName("getPriceException 테스트")
  @Test
  void getPriceException_테스트() {
    final Shop exceptionShop = new Shop("ExceptionShop");

    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(
            () -> executeGetPrice(exceptionShop::getPriceException, "product is Exception"));
  }

  private void executeGetPrice(Function<String, Future<Double>> getPrice, String product) {
    long lastTaskTimeMillis;

    stopWatch.start();

    // 1. 가격 정보를 요청
    final Future<Double> futurePrice = getPrice.apply(product);

    stopWatch.stop();
    lastTaskTimeMillis = stopWatch.getLastTaskTimeMillis();
    log.debug("[dev] {} - Invocation returned after: {} ms / {} sec", product, lastTaskTimeMillis,
        millisToSeconds(lastTaskTimeMillis));

    //---------------------------------------------------//

    stopWatch.start();

    // 2. 요청 후 다른 작업을 함
    doSomethingElse();

    try {
      // 3. 다른 작업 완료 후 Future 가 결과값을 가지고 있다면 값을 읽거나 아니면 값이 계산될 때까지 블록됨
      // get 할 때 타임아웃를 설정 할 수 있음
      final Double price = futurePrice.get();
      log.debug("[dev] price is {}", String.format("%.2f", price));
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

    stopWatch.stop();
    lastTaskTimeMillis = stopWatch.getLastTaskTimeMillis();
    log.debug("[dev] {} - Price returned after: {} ms / {} sec", product, lastTaskTimeMillis,
        millisToSeconds(lastTaskTimeMillis));
  }

  private void doSomethingElse() {
    log.debug("[dev] doSomethingElse call...");
  }

}
