package io.devfactory.example.refactoring._06_mutable_data._18_split_variable.before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle {

  private double perimeter;
  private double area;

  public void updateGeometry(double height, double width) {
    double temp = 2 * (height + width);
    log.debug("Perimeter: {}", temp);
    perimeter = temp;

    temp = height * width;
    log.debug("Area: {}", temp);
    area = temp;
  }

  public double getPerimeter() {
    return perimeter;
  }

  public double getArea() {
    return area;
  }

}
