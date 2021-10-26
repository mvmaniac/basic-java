package io.devfactory.example.designpattern.generation.factorymethod;

import io.devfactory.example.designpattern.generation.factorymethod.service.Brand;
import io.devfactory.example.designpattern.generation.factorymethod.service.Product;

public abstract class Factory {

  public Product create(Brand brand) {
    // 하위 클래스로 위임
    return createProduct(brand);
  }

  public abstract Product createProduct(Brand brand);

}
