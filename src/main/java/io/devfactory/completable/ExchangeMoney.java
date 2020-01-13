package io.devfactory.completable;

public enum ExchangeMoney {

    USD(1.0), EUR(1.35387), GBP(1.69715), CAD(.92106), MXN(.07683);

    private final double rate;

    ExchangeMoney(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

}
