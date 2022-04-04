package io.devfactory.example.designpattern._01_creational_patterns._03_abstract_factory._02_after;

import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.Ship;
import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.ShipFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class WhiteShipFactoryTest {

  @DisplayName("변경 후 추상 팩토리 패턴 테스트")
  @Test
  void afterAbstractFactory() {
    ShipFactory shipFactory = new WhiteShipFactory(new WhiteShipPartsFactory());
    Ship ship = shipFactory.createShip();
    log.debug("{}", ship.getAnchor().getClass().getSimpleName());
    log.debug("{}", ship.getWheel().getClass().getSimpleName());

    shipFactory = new WhiteShipFactory(new WhitePartsProFactory());
    ship = shipFactory.createShip();
    log.debug("{}", ship.getAnchor().getClass().getSimpleName());
    log.debug("{}", ship.getWheel().getClass().getSimpleName());
  }

}
