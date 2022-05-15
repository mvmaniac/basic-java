package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BillingTest {

  @Test
  void totalOutstanding() {
    Billing billing = new Billing(new Customer("keesun",
        List.of(new Invoice(20), new Invoice(30))), new EmailGateway());

    assertThat(billing.getTotalOutstanding()).isEqualTo(50d);
  }

}
