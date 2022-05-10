package io.devfactory.example.refactoring._17_message_chain._37_hide_delegate.before;

public class Person {

  private final String name;

  private Department department;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

}
