package io.devfactory.example.objects.movie;

import io.devfactory.example.objects.money.Money;

// 할인 정책
public interface DiscountPolicy {

  Money calculateDiscountAmount(Screening screening);

}
