package io.devfactory.designpattern.behavior.observer.service;

import io.devfactory.designpattern.behavior.observer.Observer;
import lombok.extern.slf4j.Slf4j;

// 구현체
@Slf4j
public class UserA extends Observer {

  public UserA(String name) {
    log.debug("UserA 객체를 생성합니다.");
    this.name = name;
  }

  @Override
  public void update() {
    log.debug("{} 갱신 합니다.", name);
  }

}
