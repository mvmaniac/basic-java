package io.devfactory.example.refactoring._18_middle_man._39_replace_superclass_with_delegate;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ScrollTest {

  @Test
  void daysSinceLastCleaning() {
    Scroll scroll = new Scroll(1, "whiteship", null, LocalDate.of(2022, 1, 10));
    assertThat(scroll.daysSinceLastCleaning(LocalDate.of(2022, 1, 15))).isEqualTo(5);
  }

}
