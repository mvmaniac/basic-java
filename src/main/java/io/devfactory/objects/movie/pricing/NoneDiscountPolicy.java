package io.devfactory.objects.movie.pricing;

import io.devfactory.objects.money.Money;
import io.devfactory.objects.movie.DiscountPolicy;
import io.devfactory.objects.movie.Screening;

// 할인 정책 - 없음
public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }

}
