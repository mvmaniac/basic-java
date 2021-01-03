package io.devfactory.designpattern.behavior.templatemethod.service;

public class Strawberry extends Sandwich {

  @Override
  protected String bread() {
    return "식빵";
  }

  @Override
  protected String jam() {
    return "딸기잼";
  }

}
