package io.devfactory.example.designpattern.behavior.templatemethod.service;

public class StrawberryBagel extends Sandwich {

  @Override
  protected String bread() {
    return "베이글";
  }

  @Override
  protected String jam() {
    return "딸기잼";
  }

}
