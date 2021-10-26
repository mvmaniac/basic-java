package io.devfactory.example.designpattern.behavior.memento;

import io.devfactory.example.designpattern.behavior.memento.service.Hello;
import lombok.extern.slf4j.Slf4j;

// 상태를 가지고 있는 객체
@Slf4j
public class Originator {

  // 상태를 저장하기 위해 변수를 하나 가지고 있음
  protected Hello state;
  
  // 메멘토
  // 메멘토의 객체를 생성해 반환
  public Memento create() {
    log.debug("> 메멘토 객체를 생성합니다.");
    return new Memento(state);
  }

  // 복원함
  public void restore(Memento memento) {
    log.debug("> 메멘토 객체로 복원합니다.");
    this.state = new Hello(memento.getObject());
  }
  
  // 상태
  // 상태를 읽어옴
  public Hello getState() {
    return state;
  }
  
  // 상태를 설정
  public void setState(Hello state) {
    this.state = state;
  }

}
