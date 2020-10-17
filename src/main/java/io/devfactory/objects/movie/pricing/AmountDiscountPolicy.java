package io.devfactory.objects.movie.pricing;

import io.devfactory.objects.money.Money;
import io.devfactory.objects.movie.DefaultDiscountPolicy;
import io.devfactory.objects.movie.DiscountCondition;
import io.devfactory.objects.movie.Screening;

// 할인 정책 - 금액 할인 정책
public class AmountDiscountPolicy extends DefaultDiscountPolicy {

  private Money discountAmount; // 할인 금액

  public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
    super(conditions);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return discountAmount;
  }

}
