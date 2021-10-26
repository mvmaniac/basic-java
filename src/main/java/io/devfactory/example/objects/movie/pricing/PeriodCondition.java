package io.devfactory.example.objects.movie.pricing;

import io.devfactory.example.objects.movie.DiscountCondition;
import io.devfactory.example.objects.movie.Screening;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

// 할인 조건 - 기간 조건
public class PeriodCondition implements DiscountCondition {

  private DayOfWeek dayOfWeek; // 요일
  private LocalTime startTime; // 시작 시간
  private LocalTime endTime; // 종료 시간

  public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  // Screening 의 상영 요일이 dayOfWeek 와 같고
  // 상영 시작 시간이 startTime 과 endTime 사이에 있을 경우 할인 가능
  @Override
  public boolean isSatisfiedBy(Screening screening) {
    final LocalDateTime screeningStartTime = screening.getStartTime();
    final LocalTime screeningTime = screeningStartTime.toLocalTime();

    return screeningStartTime.getDayOfWeek().equals(dayOfWeek) &&
        startTime.compareTo(screeningTime) <= 0 &&
        endTime.compareTo(screeningTime) >= 0;
  }

}
