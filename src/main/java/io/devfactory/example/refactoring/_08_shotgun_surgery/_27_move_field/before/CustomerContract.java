package io.devfactory.example.refactoring._08_shotgun_surgery._27_move_field.before;

import java.time.LocalDate;

@SuppressWarnings("ClassCanBeRecord")
public class CustomerContract {

  private final LocalDate startDate;

  public CustomerContract(LocalDate startDate) {
    this.startDate = startDate;
  }

}
