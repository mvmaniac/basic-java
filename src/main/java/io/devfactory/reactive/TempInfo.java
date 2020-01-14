package io.devfactory.reactive;

import io.devfactory.error.ServiceRuntimeException;

import java.util.Random;
import java.util.StringJoiner;

public class TempInfo {

    public static final Random random = new Random();

    private final String town;
    private final int temp;

    public TempInfo(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    public static TempInfo fetch(String town) {
        // 10분의 1 확률로 온도 가져오기 작업이 실패 함
        if (random.nextInt(10) == 0) {
            throw new ServiceRuntimeException("TempInfo fetch error...");
        }

        // 0 에서 99 사이에서 임의 화씨 온도를 반환한다.
        return new TempInfo(town, random.nextInt(100));
    }

    public String getTown() {
        return town;
    }

    public int getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TempInfo.class.getSimpleName() + "[", "]")
                .add("town='" + town + "'")
                .add("temp=" + temp)
                .toString();
    }

}
