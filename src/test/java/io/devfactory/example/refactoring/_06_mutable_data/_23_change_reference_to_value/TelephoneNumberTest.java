package io.devfactory.example.refactoring._06_mutable_data._23_change_reference_to_value;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TelephoneNumberTest {

  @Test
  void testEquals() {
    TelephoneNumber telephoneNumber1 = new TelephoneNumber("123", "1234");
    TelephoneNumber telephoneNumber2 = new TelephoneNumber("123", "1234");

    assertThat(telephoneNumber1).isEqualTo(telephoneNumber2);
  }

}
