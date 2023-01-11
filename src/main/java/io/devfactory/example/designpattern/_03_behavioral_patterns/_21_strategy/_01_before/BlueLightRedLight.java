package io.devfactory.example.designpattern._03_behavioral_patterns._21_strategy._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlueLightRedLight {

  private final int speed;

  public BlueLightRedLight(int speed) {
    this.speed = speed;
  }

  public void blueLight() {
    if (speed == 1) {
      log.debug("무 궁 화    꽃   이");
    } else if (speed == 2) {
      log.debug("무궁화꽃이");
    } else {
      log.debug("무광꼬치");
    }

  }

  public void redLight() {
    if (speed == 1) {
      log.debug("피 었 습 니  다.");
    } else if (speed == 2) {
      log.debug("피었습니다.");
    } else {
      log.debug("피어씀다");
    }
  }

}
