package io.devfactory.designpattern.structure.proxy.service;

import lombok.extern.slf4j.Slf4j;

// 실제 객체
@Slf4j
public class RealSubject implements Subject {

  public RealSubject() {
    log.debug("RealSubject 객체가 생성이 되었습니다.");
  }

  public void action1() {
    log.debug("RealSubject action1 을(를) 호출합니다.");
    log.debug("실제 action1 작업을 처리합니다.");
  }

  public void action2() {
    log.debug("RealSubject action2 을(를) 호출합니다.");
    log.debug("실제 action2 작업을 처리합니다.");
  }

}
