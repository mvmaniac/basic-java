package io.devfactory.example.refactoring._15_speculative_generality._35_remove_dead_code.before;

import java.time.LocalDateTime;

public class Reservation {

  private final String title;
  private final LocalDateTime from;
  private final LocalDateTime to;
  private LocalDateTime alarm;

  public Reservation(String title, LocalDateTime from, LocalDateTime to) {
    this.title = title;
    this.from = from;
    this.to = to;
  }

  public void setAlarmBefore(int minutes) {
    this.alarm = this.from.minusMinutes(minutes);
  }

  public LocalDateTime getAlarm() {
    return alarm;
  }

}
