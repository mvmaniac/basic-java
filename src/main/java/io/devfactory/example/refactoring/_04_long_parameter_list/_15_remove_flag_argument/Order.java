package io.devfactory.example.refactoring._04_long_parameter_list._15_remove_flag_argument;

import java.time.LocalDate;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class Order {

  private final LocalDate placedOn;
  private final String deliveryState;

  public Order(LocalDate placedOn, String deliveryState) {
    this.placedOn = placedOn;
    this.deliveryState = deliveryState;
  }

  public LocalDate getPlacedOn() {
    return placedOn;
  }

  public String getDeliveryState() {
    return deliveryState;
  }

}
