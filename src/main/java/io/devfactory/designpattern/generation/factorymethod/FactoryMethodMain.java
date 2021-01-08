package io.devfactory.designpattern.generation.factorymethod;

import io.devfactory.designpattern.generation.factorymethod.service.Product;

import static io.devfactory.designpattern.generation.factorymethod.service.Brand.LG;
import static io.devfactory.designpattern.generation.factorymethod.service.Brand.SAMSUNG;

// 팩토리 메서드 (Factory Method Pattern)
// 팩토리 패턴의 확장 패턴으로, 팩토리 패턴과 템플릿 메서드 패턴이 결합된 패턴
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
