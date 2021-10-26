package io.devfactory.example.modernjava.lambda;

import java.util.StringJoiner;

public class Apple {

  private int weight;
  private Color color;

  public Apple(int weight, Color color) {
    this.weight = weight;
    this.color = color;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Apple.class.getSimpleName() + "[", "]")
        .add("weight=" + weight)
        .add("color=" + color)
        .toString();
  }

}
