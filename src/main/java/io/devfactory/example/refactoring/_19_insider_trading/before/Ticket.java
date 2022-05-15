package io.devfactory.example.refactoring._19_insider_trading.before;

import java.time.LocalDate;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class Ticket {

  private final LocalDate purchasedDate;

  private final boolean prime;

  public Ticket(LocalDate purchasedDate, boolean prime) {
    this.purchasedDate = purchasedDate;
    this.prime = prime;
  }

  public LocalDate getPurchasedDate() {
    return purchasedDate;
  }

  public boolean isPrime() {
    return prime;
  }

}
