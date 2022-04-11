package io.devfactory.example.designpattern._02_structural_patterns._11_flyweight._02_after;


import lombok.Getter;

import java.util.StringJoiner;

@SuppressWarnings("ClassCanBeRecord")
@Getter
public final class Font {

  private final String family;
  private final int size;

  public Font(String family, int size) {
    this.family = family;
    this.size = size;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Font.class.getSimpleName() + "[", "]")
        .add("family='" + family + "'")
        .add("size=" + size)
        .toString();
  }

}
