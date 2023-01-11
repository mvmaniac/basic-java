package io.devfactory.example.refactoring._18_middle_man._38_remove_middle_man;

public class Person {

  private final Department department;
  private final String name;

  public Person(String name, Department department) {
    this.name = name;
    this.department = department;
  }

  public Department getDepartment() {
    return department;
  }

}
