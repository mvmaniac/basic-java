package io.devfactory.designpattern.generation.factorymethod;

import io.devfactory.designpattern.generation.factorymethod.service.Product;

import static io.devfactory.designpattern.generation.factorymethod.service.Brand.LG;
import static io.devfactory.designpattern.generation.factorymethod.service.Brand.SAMSUNG;

public class FactoryMethodMain {

  public static void main(String[] args) {
    final Factory factory = new ProductFactory();
    Product product;

    product = factory.create(LG);
    product.name();

    product = factory.create(SAMSUNG);
    product.name();
  }

}
