package io.devfactory.example.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.indirect_inheritance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmployeeTest {

  @Test
  void employeeType() {
    assertThat(new Employee("keesun", "manager").capitalizedType()).isEqualTo("Manager");
    assertThat(new Employee("keesun", "engineer").capitalizedType()).isEqualTo("Engineer");

    assertThatThrownBy(() -> new Employee("keesun", "wrong type"))
        .isExactlyInstanceOf(IllegalArgumentException.class);
  }

}
