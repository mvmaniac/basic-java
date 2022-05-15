package io.devfactory.example.refactoring._06_mutable_data._18_split_variable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

  @Test
  void discount() {
    Order order = new Order();

    assertThat(order.discount(50d, 100)).isEqualTo(50d);
    assertThat(order.discount(51d, 100)).isEqualTo(51d - 2);
    assertThat(order.discount(50d, 101)).isEqualTo(50d - 1);
    assertThat(order.discount(51d, 101)).isEqualTo(51d - 2 - 1);
  }

}
