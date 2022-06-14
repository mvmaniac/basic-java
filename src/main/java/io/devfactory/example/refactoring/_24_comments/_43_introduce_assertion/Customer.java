package io.devfactory.example.refactoring._24_comments._43_introduce_assertion;

import static java.util.Objects.nonNull;

public class Customer {

  private Double discountRate;

  public double applyDiscount(double amount) {
    return (this.discountRate != null) ? amount - (this.discountRate * amount) : amount;
  }

  public Double getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Double discountRate) {
     assert nonNull(discountRate) && discountRate > 0;
//    if (nonNull(discountRate) && discountRate > 0) {
//      throw new IllegalArgumentException(discountRate + " can't be minus.");
//    }
    this.discountRate = discountRate;
  }

}
