package io.devfactory.completable;

import static io.devfactory.util.CommonUtils.randomDelay;

public class Exchange {

    public static final double DEFAULT_RATE = 1.35;

    public static double getRate(ExchangeMoney source, ExchangeMoney destination) {
        return getRateWithDelay(source, destination);
    }

    private static double getRateWithDelay(ExchangeMoney source, ExchangeMoney destination) {
        randomDelay(4);
        return destination.getRate() / source.getRate();
    }

}
