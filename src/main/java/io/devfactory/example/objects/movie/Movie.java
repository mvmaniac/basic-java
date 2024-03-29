package io.devfactory.example.objects.movie;

import io.devfactory.example.objects.money.Money;
import java.time.Duration;

// 영화
public class Movie {

  private String title; // 제목
  private Duration runningTime; // 상영시간
  private Money fee; // 기본 요금
  private DiscountPolicy discountPolicy; // 할인 정책

  public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountPolicy = discountPolicy;
  }

  public String getTitle() {
    return title;
  }

  public Duration getRunningTime() {
    return runningTime;
  }

  public Money getFee() {
    return fee;
  }

  public Money calculateMovieFee(Screening screening) {
    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }

}
