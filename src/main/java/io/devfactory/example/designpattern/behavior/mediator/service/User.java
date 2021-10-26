package io.devfactory.example.designpattern.behavior.mediator.service;

import io.devfactory.example.designpattern.behavior.mediator.Colleague;
import lombok.extern.slf4j.Slf4j;

// 동료 객체
// concreteColleague
@Slf4j
public class User extends Colleague {

  protected String name;

  public User(String name) {
    log.debug("Colleague 가 등재되었습니다.");
    this.name = name;
  }

  // 사용자 이름을 확인
  public String userName() {
    return name;
  }

  // 메세지를 전달
  public void send(String data) {
    this.mediator.mediate(data, name);
  }

  public void message(String data) {
    log.debug("<< {}", data);
  }

}
