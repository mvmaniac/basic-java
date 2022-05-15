package io.devfactory.example.refactoring._06_mutable_data._22_combine_functions_into_transform;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

class ReadingClientTest {

  @Test
  void client1() {
    Client1 client1 = new Client1(acquireReading());
    assertThat(client1.getBaseCharge()).isEqualTo(100d);
  }

  @Test
  void client2() {
    Client2 client2 = new Client2(acquireReading());
    assertThat(client2.getBase()).isEqualTo(100d);
    assertThat(client2.getTaxableCharge()).isEqualTo(95d);
  }

  @Test
  void client3() {
    Client3 client3 = new Client3(acquireReading());
    assertThat(client3.getBasicChargeAmount()).isEqualTo(100d);
  }

  private Reading acquireReading() {
    return new Reading("keesun", 10, Month.DECEMBER, Year.of(2021));
  }

}
