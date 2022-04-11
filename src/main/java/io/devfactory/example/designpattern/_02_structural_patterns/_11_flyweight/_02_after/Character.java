package io.devfactory.example.designpattern._02_structural_patterns._11_flyweight._02_after;

import lombok.Getter;

import java.util.StringJoiner;

@SuppressWarnings("ClassCanBeRecord")
@Getter
public class Character {

  private final char value;
  private final String color;
  private final Font font;

  public Character(char value, String color, Font font) {
    this.value = value;
    this.color = color;
    this.font = font;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Character.class.getSimpleName() + "[", "]")
        .add("value=" + value)
        .add("color='" + color + "'")
        .add("font=" + font)
        .toString();
  }

}
