package io.devfactory.example.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

  @Test
  void fullTime() {
    Employee employee = new FullTimeEmployee();
    assertThat(employee.vacationHours()).isEqualTo(120);
    assertThat(employee.canAccessTo("new project")).isTrue();
    assertThat(employee.canAccessTo("spring")).isTrue();
  }

  @Test
  void partTime() {
    Employee employee = new PartTimeEmployee(List.of("spring", "jpa"));
    assertThat(employee.vacationHours()).isEqualTo(80);
    assertThat(employee.canAccessTo("new project")).isFalse();
    assertThat(employee.canAccessTo("spring")).isTrue();
  }

  @Test
  void temporal() {
    Employee employee = new TemporalTimeEmployee(List.of("jpa"));
    assertThat(employee.vacationHours()).isEqualTo(32);
    assertThat(employee.canAccessTo("new project")).isFalse();
    assertThat(employee.canAccessTo("spring")).isFalse();
    assertThat(employee.canAccessTo("jpa")).isTrue();
  }

}
