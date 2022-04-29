package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier;

@SuppressWarnings("ClassCanBeRecord")
public class Person {

  private final String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

}
