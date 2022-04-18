package io.devfactory.example.designpattern._03_behavioral_patterns._21_strategy._02_after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Normal implements Speed {

  @Override
  public void blueLight() {
    log.debug("무 궁 화    꽃   이");
  }

  @Override
  public void redLight() {
    log.debug("피 었 습 니  다.");
  }

}
