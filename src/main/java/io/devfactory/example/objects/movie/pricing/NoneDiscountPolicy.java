package io.devfactory.example.objects.movie.pricing;

import io.devfactory.example.objects.money.Money;
import io.devfactory.example.objects.movie.DiscountPolicy;
import io.devfactory.example.objects.movie.Screening;

// 할인 정책 - 없음
public class NoneDiscountPolicy implements DiscountPolicy {

  @Override
  public Money calculateDiscountAmount(Screening screening) {
    return Money.ZERO;
  }

}
