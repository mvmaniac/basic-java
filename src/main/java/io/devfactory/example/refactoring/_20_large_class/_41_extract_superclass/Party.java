package io.devfactory.example.refactoring._20_large_class._41_extract_superclass;

public abstract class Party {

  protected String name;

  protected Party(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  protected double annualCost() {
    return this.monthlyCost() * 12;
  }

  protected abstract double monthlyCost();

}
