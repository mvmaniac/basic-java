package io.devfactory.example.refactoring._12_repeated_swtiches;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwitchImprovementsTest {

  @Test
  void vacationHours() {
    SwitchImprovements si = new SwitchImprovements();
    assertThat(si.vacationHours("full-time")).isEqualTo(120);
  }

}
