package io.devfactory.example.refactoring._15_speculative_generality._35_remove_dead_code;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationTest {

  @Test
  void reservation() {
    Reservation reservation = new Reservation(
        LocalDateTime.of(2022, 1, 20, 19, 30)
    );
    reservation.setAlarmBefore(30);

    assertThat(reservation.getAlarm()).isEqualTo(LocalDateTime.of(2022, 1, 20, 19, 0));
  }

}
