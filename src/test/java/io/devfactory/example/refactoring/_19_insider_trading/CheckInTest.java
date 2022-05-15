package io.devfactory.example.refactoring._19_insider_trading;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CheckInTest {

  @Test
  void isFastPass() {
    assertThat(new Ticket(LocalDate.of(2021, 12, 31), true).isFastPass()).isTrue();
    assertThat(new Ticket(LocalDate.of(2021, 12, 31), false).isFastPass()).isFalse();
    assertThat(new Ticket(LocalDate.of(2022, 1, 2), true).isFastPass()).isFalse();
  }

}
