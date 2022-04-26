package io.devfactory.example.refactoring._04_long_parameter_list._15_remove_flag_argument;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ShipmentTest {

  @Test
  void deliveryDate() {
    LocalDate placedOn = LocalDate.of(2021, 12, 15);
    Order orderFromWA = new Order(placedOn, "WA");

    Shipment shipment = new Shipment();

    assertThat(shipment.rushDeliveryDate(orderFromWA)).isEqualTo(placedOn.plusDays(1));
    assertThat(shipment.regularDeliveryDate(orderFromWA)).isEqualTo(placedOn.plusDays(2));
  }

}
