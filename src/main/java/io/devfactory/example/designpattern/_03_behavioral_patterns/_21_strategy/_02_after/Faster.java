package io.devfactory.example.designpattern._03_behavioral_patterns._21_strategy._02_after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Faster implements Speed {

  @Override
  public void blueLight() {
    log.debug("무궁화꽃이");
  }

  @Override
  public void redLight() {
    log.debug("피었습니다.");
  }

}
