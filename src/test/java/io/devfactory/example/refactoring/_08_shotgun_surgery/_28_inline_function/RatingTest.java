package io.devfactory.example.refactoring._08_shotgun_surgery._28_inline_function;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RatingTest {

  @Test
  void rating() {
    Rating rating = new Rating();
    assertThat(rating.rating(new Driver(15))).isEqualTo(2);
    assertThat(rating.rating(new Driver(15))).isEqualTo(1);
  }

}
