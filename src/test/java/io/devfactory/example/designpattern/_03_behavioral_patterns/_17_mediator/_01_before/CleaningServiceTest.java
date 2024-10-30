package io.devfactory.example.designpattern._03_behavioral_patterns._17_mediator._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@SuppressWarnings("squid:S1186")
@Slf4j
class CleaningServiceTest {

  @DisplayName("변경 전 중재자 패턴")
  @Test
  void testMediator() {
    Guest guest = new Guest();
    guest.getTower(3);
    guest.dinner();

    Restaurant restaurant = new Restaurant();
    restaurant.clean();
  }

}
