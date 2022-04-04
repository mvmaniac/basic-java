package io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after;

import io.devfactory.example.designpattern._01_creational_patterns._03_abstract_factory._02_after.Anchor;
import io.devfactory.example.designpattern._01_creational_patterns._03_abstract_factory._02_after.Wheel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.StringJoiner;

@RequiredArgsConstructor
@Getter
public class Ship {

  private final String name;
  private final String color;
  private final String logo;

  private Anchor anchor;
  private Wheel wheel;

  public void changeAnchor(Anchor anchor) {
    this.anchor = anchor;
  }

  public void changeWheel(Wheel wheel) {
    this.wheel = wheel;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Ship.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("color='" + color + "'")
        .add("logo='" + logo + "'")
        .add("anchor=" + anchor)
        .add("wheel=" + wheel)
        .toString();
  }

}
