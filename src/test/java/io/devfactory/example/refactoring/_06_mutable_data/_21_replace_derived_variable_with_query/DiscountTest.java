package io.devfactory.example.refactoring._06_mutable_data._21_replace_derived_variable_with_query;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountTest {

  @Test
  void discount() {
    Discount discount = new Discount(100);
    // assertThat(discount.getDiscountedTotal()).isEqualTo(100);

    discount.setDiscountedValue(10);
    assertThat(discount.getDiscountedTotal()).isEqualTo(90);
  }

}
