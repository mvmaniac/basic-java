package io.devfactory.example.refactoring._16_temporary_field._36_introduce_special_case;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerServiceTest {

  CustomerService customerService = new CustomerService();
  Customer unknown = new Customer("unknown", null, null);

  BillingPlan keesunBillingPlan = new BillingPlan();
  Customer keesun = new Customer("keesun", keesunBillingPlan, new PaymentHistory(1));

  @Test
  void customerName() {
    String unknownCustomerName = customerService.customerName(new Site(unknown));
    assertThat(unknownCustomerName).isEqualTo("occupant");

    String customer = customerService.customerName(new Site(keesun));
    assertThat(customer).isEqualTo("keesun");
  }

  @Test
  void billingPlan() {
    assertThat(customerService.billingPlan(new Site(unknown))).isInstanceOf(BasicBillingPlan.class);
    assertThat(customerService.billingPlan(new Site(keesun))).isEqualTo(keesunBillingPlan);
  }

  @Test
  void weeksDelinquent() {
    assertThat(customerService.weeksDelinquent(new Site(keesun))).isEqualTo(1);
    assertThat(customerService.weeksDelinquent(new Site(unknown))).isZero();
  }

}
