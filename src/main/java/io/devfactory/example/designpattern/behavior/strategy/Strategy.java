package io.devfactory.example.designpattern.behavior.strategy;

import io.devfactory.example.designpattern.behavior.strategy.service.Weapon;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Strategy {

  // 추상적인 접근성
  protected Weapon delegate;

  public void changeWeapon(Weapon weapon) {
    log.debug("== 무기를 교환합니다. ==");
    delegate = weapon;
  }

  public abstract void attack();

}
