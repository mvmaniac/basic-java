package io.devfactory.example.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmployeeTest {

  @Test
  void employeeType() {
    assertThat(Employee.createEmployee("keesun", "engineer").getType()).isEqualTo("engineer");
    assertThat(Employee.createEmployee("keesun", "manager").getType()).isEqualTo("manager");

    assertThatThrownBy(() -> Employee.createEmployee("keesun", "wrong type"))
        .isExactlyInstanceOf(IllegalArgumentException.class);
  }

}
