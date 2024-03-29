package io.devfactory.example.refactoring._07_divergent_change._25_move_function.before;

public class Account {

  private final int daysOverdrawn;

  private final AccountType type;

  public Account(int daysOverdrawn, AccountType type) {
    this.daysOverdrawn = daysOverdrawn;
    this.type = type;
  }

  public double getBankCharge() {
    double result = 4.5;
    if (this.daysOverdrawn() > 0) {
      result += this.overdraftCharge();
    }
    return result;
  }

  private int daysOverdrawn() {
    return this.daysOverdrawn;
  }

  private double overdraftCharge() {
    if (this.type.isPremium()) {
      final int baseCharge = 10;
      if (this.daysOverdrawn <= 7) {
        return baseCharge;
      } else {
        return baseCharge + (this.daysOverdrawn - 7) * 0.85;
      }
    } else {
      return this.daysOverdrawn * 1.75;
    }
  }

}
