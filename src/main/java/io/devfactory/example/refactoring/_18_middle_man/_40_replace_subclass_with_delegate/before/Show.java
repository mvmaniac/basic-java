package io.devfactory.example.refactoring._18_middle_man._40_replace_subclass_with_delegate.before;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class Show {

  private final List<String> properties;

  private final double price;

  public Show(List<String> properties, double price) {
    this.properties = properties;
    this.price = price;
  }

  public boolean hasOwnProperty(String property) {
    return this.properties.contains(property);
  }

  public double getPrice() {
    return price;
  }

}
