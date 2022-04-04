package io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ShipFactoryTest {

  @DisplayName("변경 전 팩토리 메소드 패턴 테스트")
  @Test
  void beforeFactoryMethod() {
    Ship ship = ShipFactory.orderShip("Whiteship", "keesun@mail.com");
    log.debug("{}", ship);

    ship = ShipFactory.orderShip("Blackship", "keesun@mail.com");
    log.debug("{}", ship);
  }

}
