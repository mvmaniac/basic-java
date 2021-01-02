package io.devfactory.designpattern.behavior.memento;

import io.devfactory.designpattern.behavior.memento.service.Hello;

// 메멘토
public class Memento {

  // 객체를 저장
  protected Hello object;

  // 원조본(Originator)에 의해서 생성 함
  public Memento(Hello hello) {
    // 객체를 복제
    this.object = new Hello(hello);
  }

  // 저장된 객체를 읽어옴
  public Hello getObject() {
    return object;
  }

}
