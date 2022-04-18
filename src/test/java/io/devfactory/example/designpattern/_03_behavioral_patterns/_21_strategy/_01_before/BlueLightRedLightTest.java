package io.devfactory.example.designpattern._03_behavioral_patterns._21_strategy._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class BlueLightRedLightTest {

  @DisplayName("변경 전 전략 패턴 테스트")
  @Test
  void testStrategy() {
    BlueLightRedLight blueLightRedLight = new BlueLightRedLight(3);
    blueLightRedLight.blueLight();
    blueLightRedLight.redLight();
  }

}
