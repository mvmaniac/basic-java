package io.devfactory.example.refactoring._08_shotgun_surgery._28_inline_function.before;

public class Rating {

  public int rating(Driver driver) {
    return moreThanFiveLateDeliveries(driver) ? 2 : 1;
  }

  private boolean moreThanFiveLateDeliveries(Driver driver) {
    return driver.getNumberOfLateDeliveries() > 5;
  }

}
