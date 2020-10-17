package io.devfactory.objects.movie;

import io.devfactory.objects.money.Money;

// 할인 정책
public interface DiscountPolicy {

  Money calculateDiscountAmount(Screening screening);

}
