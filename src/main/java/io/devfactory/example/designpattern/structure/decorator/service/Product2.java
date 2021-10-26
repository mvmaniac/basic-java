package io.devfactory.example.designpattern.structure.decorator.service;

// ConcreateComponent
public class Product2 implements Component {

  @Override
  public String product() {
    return "블라우스";
  }

  @Override
  public int price() {
    return 25_000;
  }

}
