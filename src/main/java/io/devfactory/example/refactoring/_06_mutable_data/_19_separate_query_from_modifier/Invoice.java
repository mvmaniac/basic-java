package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier;

@SuppressWarnings("ClassCanBeRecord")
public class Invoice {

  private final double amount;

  public Invoice(double amount) {
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

}
