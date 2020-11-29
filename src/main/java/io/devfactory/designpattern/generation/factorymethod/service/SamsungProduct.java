package io.devfactory.designpattern.generation.factorymethod.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SamsungProduct implements Product {

  @Override
  public void name() {
    log.debug("Samsung Always Laptop");
  }

}
