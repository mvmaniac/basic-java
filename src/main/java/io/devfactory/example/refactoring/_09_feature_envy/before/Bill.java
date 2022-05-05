package io.devfactory.example.refactoring._09_feature_envy.before;

public class Bill {

    private ElectricityUsage electricityUsage;

    private GasUsage gasUsage;

    public double calculateBill() {
        var electricityBill = electricityUsage.getAmount() * electricityUsage.getPricePerUnit();
        var gasBill = gasUsage.getAmount() * gasUsage.getPricePerUnit();
        return electricityBill + gasBill;
    }

}
