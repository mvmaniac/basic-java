package io.devfactory.util;

import lombok.experimental.UtilityClass;

import java.util.concurrent.TimeUnit;

// @UtilityClass 를 통한 static 은 static import 가 안되므로 명시적으로 선엄함
// https://projectlombok.org/features/experimental/UtilityClass
@UtilityClass
public class CommonUtils {

    public static void delay(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException("delay interrupted exception...");
        }
    }

    public static long millisToSeconds(long millis) {
        return TimeUnit.MILLISECONDS.toSeconds(millis);
    }

}
