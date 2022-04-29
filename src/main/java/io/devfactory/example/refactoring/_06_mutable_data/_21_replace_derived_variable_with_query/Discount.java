package io.devfactory.example.refactoring._06_mutable_data._21_replace_derived_variable_with_query;

public class Discount {

  private final double baseTotal;

  private double discountedValue;

  public Discount(double baseTotal) {
    this.baseTotal = baseTotal;
  }

  public double getDiscountedTotal() {
    return this.baseTotal - this.discountedValue;
  }

  public void setDiscountedValue(double number) {
    this.discountedValue = number;
  }

}
