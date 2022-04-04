package io.devfactory.example.designpattern._01_creational_patterns._03_abstract_factory._01_before;


import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.Ship;
import io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after.ShipFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class WhiteShipFactoryTest {

  @DisplayName("변경 전 추상 팩토리 패턴 테스트")
  @Test
  void beforeAbstractFactory() {
    ShipFactory shipFactory = new WhiteShipFactory();
    Ship ship = shipFactory.createShip();
    log.debug("{}", ship.getAnchor().getClass().getSimpleName());
    log.debug("{}", ship.getWheel().getClass().getSimpleName());
  }

}
