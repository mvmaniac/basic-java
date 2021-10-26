package io.devfactory.example.designpattern.behavior.mediator;

import java.util.List;

// 중재자 인터페이스
public abstract class Mediator<T> {
  
  // 중재해야 할 객체의 목록을 가지고 있음
  protected List<T> colleagues;

  // Colleague 를 추가
  public void addColleague(T colleague) {
    colleagues.add(colleague);
  }

  // 중재 기능
  public abstract void mediate(String data, String user);

}
