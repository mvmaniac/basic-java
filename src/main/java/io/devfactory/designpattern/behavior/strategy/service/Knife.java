package io.devfactory.designpattern.behavior.strategy.service;

import lombok.extern.slf4j.Slf4j;

// 무기 인터페이스를 적용하여 객체의 실제 코드 구현을 작성
@Slf4j
public class Knife implements Weapon {

  @Override
  public void attack() {
    log.debug("칼 공격합니다.");
  }

}
