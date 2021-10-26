package io.devfactory.example.objects.movie;

import io.devfactory.example.objects.money.Money;
import java.util.Arrays;
import java.util.List;

// 기본 할인 정책
public abstract class DefaultDiscountPolicy {

  private List<DiscountCondition> conditions; // 할인 조건

  public DefaultDiscountPolicy(DiscountCondition... conditions) {
    this.conditions = Arrays.asList(conditions);
  }

  public Money calculateDiscountAmount(Screening screening) {
    for (DiscountCondition condition : conditions) {
      // 할인 조건을 만족하는 경우
      if (condition.isSatisfiedBy(screening)) {
        return getDiscountAmount(screening);
      }
    }

    return Money.ZERO;
  }

  protected abstract Money getDiscountAmount(Screening screening);

}
