package io.devfactory.designpattern.structure.proxy;

import io.devfactory.designpattern.structure.proxy.service.Subject;
import lombok.extern.slf4j.Slf4j;

// 프록시 객체
@Slf4j
public class Proxy implements Subject {

  private final Subject subject;

  public Proxy(Subject real) {
    log.debug("Proxy 객체가 생성이 되었습니다.");
    this.subject = real;
  }

  @Override
  public void action1() {
    log.debug("Proxy action1 을(를) 호출합니다.");

    // 행위를 가로챔, 실제 객체로 위임
    this.subject.action1();
  }

  @Override
  public void action2() {
    log.debug("Proxy action2 을(를) 호출합니다.");

    // 행위를 가로챔, 실제 객체로 위임
    this.subject.action1();
  }

}
