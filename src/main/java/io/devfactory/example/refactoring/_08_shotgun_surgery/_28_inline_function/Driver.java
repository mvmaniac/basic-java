package io.devfactory.example.refactoring._08_shotgun_surgery._28_inline_function;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class Driver {

  private final int numberOfLateDeliveries;

  public Driver(int numberOfLateDeliveries) {
    this.numberOfLateDeliveries = numberOfLateDeliveries;
  }

  public int getNumberOfLateDeliveries() {
    return this.numberOfLateDeliveries;
  }

}
