package io.devfactory.example.refactoring._08_shotgun_surgery._27_move_field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

  @Test
  void applyDiscount() {
    Customer customer = new Customer("keesun", 0.5);
    assertThat(customer.applyDiscount(100)).isEqualTo(50);

    customer.becomePreferred();
    assertThat(customer.applyDiscount(100)).isEqualTo(47);
  }

}
