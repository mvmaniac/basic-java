package io.devfactory.example.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance.before;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class Employee {

  private final String name;

  private final String type;

  public Employee(String name, String type) {
    this.validate(type);
    this.name = name;
    this.type = type;
  }

  private void validate(String type) {
    List<String> legalTypes = List.of("engineer", "manager", "salesman");
    if (!legalTypes.contains(type)) {
      throw new IllegalArgumentException(type);
    }
  }

  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", type='" + type + '\'' +
        '}';
  }

}
