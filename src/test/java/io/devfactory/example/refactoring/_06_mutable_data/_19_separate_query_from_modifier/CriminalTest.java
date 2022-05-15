package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CriminalTest {

  @Test
  void alertForMiscreant() {
    Criminal criminal = new Criminal();
    String found = criminal.findMiscreant(List.of(new Person("Keesun"), new Person("Don")));
    assertThat(found).isEqualTo("Don");

    found = criminal.findMiscreant(List.of(new Person("John"), new Person("Don")));
    assertThat(found).isEqualTo("John");

    found = criminal.findMiscreant(List.of(new Person("dev"), new Person("test")));
    assertThat(found).isEmpty();
  }

}
