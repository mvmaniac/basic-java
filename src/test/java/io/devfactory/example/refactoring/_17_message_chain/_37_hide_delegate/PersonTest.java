package io.devfactory.example.refactoring._17_message_chain._37_hide_delegate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

  @Test
  void manager() {
    Person keesun = new Person("keesun");
    Person nick = new Person("nick");
    keesun.setDepartment(new Department("m365deploy", nick));

    Person manager = keesun.getManager();
    assertThat(nick).isEqualTo(manager);
  }

}
