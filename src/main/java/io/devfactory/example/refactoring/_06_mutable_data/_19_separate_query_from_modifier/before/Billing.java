package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier.before;

import io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier.Customer;
import io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier.EmailGateway;
import io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier.Invoice;

public class Billing {

  private final Customer customer;

  private final EmailGateway emailGateway;

  public Billing(Customer customer, EmailGateway emailGateway) {
    this.customer = customer;
    this.emailGateway = emailGateway;
  }

  public double getTotalOutstandingAndSendBill() {
    double result = customer.getInvoices().stream()
        .map(Invoice::getAmount)
        .reduce((double) 0, Double::sum);
    sendBill();
    return result;
  }

  private void sendBill() {
    emailGateway.send(formatBill(customer));
  }

  private String formatBill(Customer customer) {
    return "sending bill for " + customer.getName();
  }

}
