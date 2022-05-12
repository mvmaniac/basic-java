package io.devfactory.example.refactoring._18_middle_man._38_remove_middle_man;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

  @Test
  void getManager() {
    Person nick = new Person("nick", null);
    Person keesun = new Person("keesun", new Department(nick));
    assertThat(keesun.getDepartment().getManager()).isEqualTo(nick);
  }

}
