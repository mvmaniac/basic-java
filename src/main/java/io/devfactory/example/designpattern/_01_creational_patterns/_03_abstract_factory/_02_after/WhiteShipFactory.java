package io.devfactory.example.designpattern._01_creational_patterns._03_abstract_factory._02_after;

import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.DefaultShipFactory;
import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.Ship;
import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.WhiteShip;

public class WhiteShipFactory extends DefaultShipFactory {

  private final ShipPartsFactory shipPartsFactory;

  public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
    this.shipPartsFactory = shipPartsFactory;
  }

  @Override
  public Ship createShip() {
    Ship ship = new WhiteShip();
    ship.changeAnchor(shipPartsFactory.createAnchor());
    ship.changeWheel(shipPartsFactory.createWheel());
    return ship;
  }

}
