package io.devfactory.objects.movie.pricing;

import io.devfactory.objects.movie.DiscountCondition;
import io.devfactory.objects.movie.Screening;

// 할인 조건 - 순번(순서) 조건
public class SequenceCondition implements DiscountCondition {

  private int sequence; // 순번

  public SequenceCondition(int sequence) {
    this.sequence = sequence;
  }

  // Screening 의 상영 순번과 일치하는 경우 할인 가능
  @Override
  public boolean isSatisfiedBy(Screening screening) {
    return screening.isSequence(sequence);
  }

}
