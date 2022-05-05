package io.devfactory.example.refactoring._09_feature_envy;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class GasUsage {

  private final double amount;

  private final double pricePerUnit;

  public GasUsage(double amount, double pricePerUnit) {
    this.amount = amount;
    this.pricePerUnit = pricePerUnit;
  }

  public double getAmount() {
    return this.amount;
  }

  public double getPricePerUnit() {
    return this.pricePerUnit;
  }

  public double getGasBill() {
    return this.getAmount() * this.getPricePerUnit();
  }

}
