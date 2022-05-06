package io.devfactory.example.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches;

import java.util.List;

public class TemporalTimeEmployee extends Employee {

  public TemporalTimeEmployee(List<String> availableProjects) {
    super(availableProjects);
  }

  @Override
  public int vacationHours() {
    return 32;
  }

}
