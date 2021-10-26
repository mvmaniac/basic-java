package io.devfactory.example.designpattern.behavior.visitor.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Product {

  protected String name;
  protected int price;
  protected int num;

}
