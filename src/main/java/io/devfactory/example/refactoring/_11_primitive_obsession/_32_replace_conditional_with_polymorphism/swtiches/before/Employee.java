package io.devfactory.example.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches.before;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class Employee {

  private final String type;

  private final List<String> availableProjects;

  public Employee(String type, List<String> availableProjects) {
    this.type = type;
    this.availableProjects = availableProjects;
  }

  public int vacationHours() {
    return switch (type) {
      case "full-time" -> 120;
      case "part-time" -> 80;
      case "temporal" -> 32;
      default -> 0;
    };
  }

  public boolean canAccessTo(String project) {
    return switch (type) {
      case "full-time" -> true;
      case "part-time", "temporal" -> this.availableProjects.contains(project);
      default -> false;
    };
  }

}
