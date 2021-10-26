package io.devfactory.example.designpattern.generation.factorymethod;

import io.devfactory.example.designpattern.generation.factorymethod.service.Brand;
import io.devfactory.example.designpattern.generation.factorymethod.service.LgProduct;
import io.devfactory.example.designpattern.generation.factorymethod.service.Product;
import io.devfactory.example.designpattern.generation.factorymethod.service.SamsungProduct;
import io.devfactory.global.error.ServiceRuntimeException;
import lombok.extern.slf4j.Slf4j;

import static io.devfactory.example.designpattern.generation.factorymethod.service.Brand.LG;
import static io.devfactory.example.designpattern.generation.factorymethod.service.Brand.SAMSUNG;

@Slf4j
public class ProductFactory extends Factory {

  public ProductFactory() {
    log.debug("ProductFactory 객체를 생성합니다.");
  }

  @Override
  public Product createProduct(Brand brand) {
    if (brand == LG) {
      return new LgProduct();
    } else if (brand == SAMSUNG) {
      return new SamsungProduct();
    }

    throw new ServiceRuntimeException();
  }

}
