package io.devfactory.example.modernjava.stream;

import java.util.StringJoiner;

public class Transaction {

  private final Trader trader;
  private final int year;
  private final int value;

  public Transaction(Trader trader, int year, int value) {
    this.trader = trader;
    this.year = year;
    this.value = value;
  }

  public Trader getTrader() {
    return trader;
  }

  public int getYear() {
    return year;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Transaction.class.getSimpleName() + "[", "]")
        .add("trader=" + trader)
        .add("year=" + year)
        .add("value=" + value)
        .toString();
  }

}
