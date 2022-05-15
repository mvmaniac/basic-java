package io.devfactory.example.refactoring._06_mutable_data._18_split_variable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HaggisTest {

  @Test
  void distance() {
    Haggis haggis = new Haggis(10d, 20d, 10, 5);

    assertThat(haggis.distanceTravelled(10)).isEqualTo(50d);
    assertThat(haggis.distanceTravelled(20)).isEqualTo(125d);
  }

}
