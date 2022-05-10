package io.devfactory.example.refactoring._16_temporary_field._36_introduce_special_case;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class Site {

  private final Customer customer;

  public Site(Customer customer) {
    this.customer = "unknown".equals(customer.getName()) ? new UnknownCustomer() : customer;
  }

  public Customer getCustomer() {
    return customer;
  }

}
