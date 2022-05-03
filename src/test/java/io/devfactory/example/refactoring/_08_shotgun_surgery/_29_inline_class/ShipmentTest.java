package io.devfactory.example.refactoring._08_shotgun_surgery._29_inline_class;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShipmentTest {

  @Test
  void trackingInfo() {
    Shipment shipment = new Shipment("UPS", "12345");
    assertThat(shipment.getTrackingInfo()).isEqualTo("UPS: 12345");
  }

}
