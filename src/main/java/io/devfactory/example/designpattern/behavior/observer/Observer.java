package io.devfactory.example.designpattern.behavior.observer;

import lombok.Getter;

// 감시자 인터페이스
@Getter
public abstract class Observer {

  // 감시자 이름
  protected String name;

  // 상태 업데이트
  public abstract void update();

}
