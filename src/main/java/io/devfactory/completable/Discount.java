package io.devfactory.completable;

import static io.devfactory.util.CommonUtils.randomDelay;
import static java.lang.String.format;

public class Discount {

    private Discount() {}

    public static String applyDiscount(Quote quote) {
        return format("%s price is %s", quote.getShopName(), Discount.apply(quote.getPrice(), quote.getDiscountCode()));
    }

    private static double apply(double price, DiscountCode code) {
        randomDelay(3);
        return price * (100 - code.getPercentage()) / 100;
    }

}
