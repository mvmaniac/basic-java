package io.devfactory.example.refactoring._15_speculative_generality._35_remove_dead_code;

import java.time.LocalDateTime;

public class Reservation {

  private final LocalDateTime from;
  private LocalDateTime alarm;

  public Reservation(LocalDateTime from) {
    this.from = from;
  }

  public void setAlarmBefore(int minutes) {
    this.alarm = this.from.minusMinutes(minutes);
  }

  public LocalDateTime getAlarm() {
    return alarm;
  }

}
