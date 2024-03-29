package io.devfactory.example.refactoring._09_feature_envy;

public class Bill {

  private ElectricityUsage electricityUsage;

  private GasUsage gasUsage;

  public double calculateBill() {
    return electricityUsage.getElectricityBill() + gasUsage.getGasBill();
  }

}
