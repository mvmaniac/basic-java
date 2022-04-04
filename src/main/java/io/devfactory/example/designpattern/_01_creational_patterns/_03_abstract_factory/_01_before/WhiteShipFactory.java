package io.devfactory.example.designpattern._01_creational_patterns._03_abstract_factory._01_before;

import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.DefaultShipFactory;
import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.Ship;
import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.WhiteShip;

public class WhiteShipFactory extends DefaultShipFactory {

  @Override
  public Ship createShip() {
    Ship ship = new WhiteShip();
    ship.changeAnchor(new WhiteAnchor());
    ship.changeWheel(new WhiteWheel());
    return ship;
  }

}
