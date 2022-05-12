package io.devfactory.example.refactoring._18_middle_man._38_remove_middle_man.before;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class Department {

  private final Person manager;

  public Department(Person manager) {
    this.manager = manager;
  }

  public Person getManager() {
    return manager;
  }

}
