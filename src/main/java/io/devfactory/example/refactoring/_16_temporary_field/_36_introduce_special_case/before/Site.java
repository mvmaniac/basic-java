package io.devfactory.example.refactoring._16_temporary_field._36_introduce_special_case.before;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class Site {

  private final Customer customer;

  public Site(Customer customer) {
    this.customer = customer;
  }

  public Customer getCustomer() {
    return customer;
  }

}
