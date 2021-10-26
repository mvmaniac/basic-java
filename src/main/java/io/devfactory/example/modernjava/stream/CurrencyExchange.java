package io.devfactory.example.modernjava.stream;

import java.util.StringJoiner;

public class CurrencyExchange {

  private Currency currency;
  private double value;

  public CurrencyExchange(Currency currency, double value) {
    this.currency = currency;
    this.value = value;
  }

  public Currency getCurrency() {
    return currency;
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", CurrencyExchange.class.getSimpleName() + "[", "]")
        .add("currency=" + currency)
        .add("value=" + value)
        .toString();
  }

}
