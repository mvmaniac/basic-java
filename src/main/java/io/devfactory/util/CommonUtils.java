package io.devfactory.util;

import io.devfactory.error.ServiceRuntimeException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

// @UtilityClass 를 통한 static 은 static import 가 안되므로 명시적으로 선엄함
// https://projectlombok.org/features/experimental/UtilityClass
@Slf4j
@UtilityClass
public class CommonUtils {

  public static final Random random = new Random();

  public static void delay(int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {
      // Restore interrupted state...
      Thread.currentThread().interrupt();
      throw new ServiceRuntimeException("delay interrupted exception...");
    }
  }

  public static void randomDelay(int maxSeconds) {
    try {
      // 최소 0.5초 이상되려고 500을 더함
      final int millis = random.nextInt(maxSeconds * 1000) + 500;

      log.debug("[dev] randomDelay: {} ms / {} sec", millis, millisToSeconds(millis));

      TimeUnit.MILLISECONDS.sleep(millis);
    } catch (InterruptedException e) {
      // Restore interrupted state...
      Thread.currentThread().interrupt();
      throw new ServiceRuntimeException("randomDelay interrupted exception...");
    }
  }

  public static long millisToSeconds(long millis) {
    return TimeUnit.MILLISECONDS.toSeconds(millis);
  }

}
