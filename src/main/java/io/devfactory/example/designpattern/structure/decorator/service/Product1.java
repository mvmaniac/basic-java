package io.devfactory.example.designpattern.structure.decorator.service;

// ConcreateComponent
public class Product1 implements Component {

  @Override
  public String product() {
    return "원피스";
  }

  @Override
  public int price() {
    return 20_000;
  }

}
