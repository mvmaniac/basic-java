package io.devfactory.example.designpattern._03_behavioral_patterns._21_strategy._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class BlueLightRedLightTest {

  @DisplayName("변경 후 전략 패턴 테스트")
  @Test
  void testStrategy() {
    BlueLightRedLight game = new BlueLightRedLight();
    game.blueLight(new Normal());
    game.redLight(new Fastest());
    game.blueLight(new Speed() {
      @Override
      public void blueLight() {
        log.debug("blue light");
      }

      @Override
      public void redLight() {
        log.debug("red light");
      }
    });
  }

}
