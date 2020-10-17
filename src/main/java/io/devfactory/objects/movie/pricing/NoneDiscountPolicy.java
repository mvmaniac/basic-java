package io.devfactory.objects.movie.pricing;

import io.devfactory.objects.money.Money;
import io.devfactory.objects.movie.DiscountPolicy;
import io.devfactory.objects.movie.Screening;

// 할인 정책 - 없음
public class NoneDiscountPolicy implements DiscountPolicy {

  @Override
  public Money calculateDiscountAmount(Screening screening) {
    return Money.ZERO;
  }

}
