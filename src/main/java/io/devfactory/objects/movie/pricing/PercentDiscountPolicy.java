package io.devfactory.objects.movie.pricing;

import io.devfactory.objects.money.Money;
import io.devfactory.objects.movie.DefaultDiscountPolicy;
import io.devfactory.objects.movie.DiscountCondition;
import io.devfactory.objects.movie.Screening;

// 할인 정책 - 비율 할인 정책
public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent; // 할인 비율

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }

}
