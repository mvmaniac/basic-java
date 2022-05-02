package io.devfactory.example.refactoring._07_divergent_change._25_move_function.before;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class AccountType {

  private final boolean premium;

  public AccountType(boolean premium) {
    this.premium = premium;
  }

  public boolean isPremium() {
    return this.premium;
  }

}
