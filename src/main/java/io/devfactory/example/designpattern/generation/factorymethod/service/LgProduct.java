package io.devfactory.example.designpattern.generation.factorymethod.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LgProduct implements Product {

  @Override
  public void name() {
    log.debug("LG Gram Laptop");
  }

}
