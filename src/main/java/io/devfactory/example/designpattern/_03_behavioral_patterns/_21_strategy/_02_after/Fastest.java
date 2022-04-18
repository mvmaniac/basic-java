package io.devfactory.example.designpattern._03_behavioral_patterns._21_strategy._02_after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fastest implements Speed {

  @Override
  public void blueLight() {
    log.debug("무광꼬치");
  }

  @Override
  public void redLight() {
    log.debug("피어씀다.");
  }

}
