package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class Customer {

  private final String name;

  private final List<Invoice> invoices;

  public Customer(String name, List<Invoice> invoices) {
    this.name = name;
    this.invoices = invoices;
  }

  public List<Invoice> getInvoices() {
    return invoices;
  }

  public String getName() {
    return name;
  }

}
