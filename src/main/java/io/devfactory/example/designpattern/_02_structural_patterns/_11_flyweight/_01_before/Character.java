package io.devfactory.example.designpattern._02_structural_patterns._11_flyweight._01_before;

import lombok.Getter;

import java.util.StringJoiner;

@SuppressWarnings("ClassCanBeRecord")
@Getter
public class Character {

  private final char value;
  private final String color;
  private final String fontFamily;
  private final int fontSize;

  public Character(char value, String color, String fontFamily, int fontSize) {
    this.value = value;
    this.color = color;
    this.fontFamily = fontFamily;
    this.fontSize = fontSize;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Character.class.getSimpleName() + "[", "]")
        .add("value=" + value)
        .add("color='" + color + "'")
        .add("fontFamily='" + fontFamily + "'")
        .add("fontSize=" + fontSize)
        .toString();
  }

}
