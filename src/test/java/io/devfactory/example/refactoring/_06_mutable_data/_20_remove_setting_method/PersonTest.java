package io.devfactory.example.refactoring._06_mutable_data._20_remove_setting_method;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

  @Test
  void person() {
    Person person = new Person(10);
    person.setName("keesun");
    assertThat(person.getId()).isEqualTo(10);
    assertThat(person.getName()).isEqualTo("keesun");

    person.setName("whiteship");
    assertThat(person.getName()).isEqualTo("whiteship");
  }

}
