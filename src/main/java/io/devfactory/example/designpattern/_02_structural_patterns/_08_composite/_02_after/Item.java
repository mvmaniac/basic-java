package io.devfactory.example.designpattern._02_structural_patterns._08_composite._02_after;

import lombok.Getter;

@SuppressWarnings("ClassCanBeRecord")
@Getter
public class Item implements Component {

  private final String name;
  private final int price;

  public Item(String name, int price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public int getPrice() {
    return this.price;
  }

}
