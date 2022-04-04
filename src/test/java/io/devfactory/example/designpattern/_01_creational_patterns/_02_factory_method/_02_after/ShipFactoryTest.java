package io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ShipFactoryTest {

  @DisplayName("변경 후 팩토리 메소드 패턴 테스트")
  @Test
  void afterFactoryMethod() {
    Ship ship = new WhiteShipFactory().createShip();
    log.debug("{}", ship);

    ship = new BlackShipFactory().createShip();
    log.debug("{}", ship);
  }

}
