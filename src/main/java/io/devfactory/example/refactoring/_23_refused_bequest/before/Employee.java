package io.devfactory.example.refactoring._23_refused_bequest.before;

public class Employee {

  protected Quota quota;

  protected Quota getQuota() {
    return new Quota();
  }

}
