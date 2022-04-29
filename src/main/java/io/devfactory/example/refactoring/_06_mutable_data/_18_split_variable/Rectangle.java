package io.devfactory.example.refactoring._06_mutable_data._18_split_variable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle {

  private double perimeter;
  private double area;

  public void updateGeometry(double height, double width) {
    double calculatedPerimeter = 2 * (height + width);
    log.debug("Perimeter: {}", calculatedPerimeter);
    this.perimeter = calculatedPerimeter;

    this.area = height * width;
    log.debug("Area: {}", area);
  }

  public double getPerimeter() {
    return perimeter;
  }

  public double getArea() {
    return area;
  }

}
