package io.devfactory.example.refactoring._16_temporary_field._36_introduce_special_case.before;

public class CustomerService {

  private static final String CUSTOMER_UNKNOWN = "unknown";

  public String customerName(Site site) {
    Customer customer = site.getCustomer();

    String customerName;
    if (customer.getName().equals(CUSTOMER_UNKNOWN)) {
      customerName = "occupant";
    } else {
      customerName = customer.getName();
    }

    return customerName;
  }

  public BillingPlan billingPlan(Site site) {
    Customer customer = site.getCustomer();
    return customer.getName().equals(CUSTOMER_UNKNOWN) ? new BasicBillingPlan() : customer.getBillingPlan();
  }

  public int weeksDelinquent(Site site) {
    Customer customer = site.getCustomer();
    return customer.getName().equals(CUSTOMER_UNKNOWN) ? 0 : customer.getPaymentHistory().getWeeksDelinquentInLastYear();
  }

}
