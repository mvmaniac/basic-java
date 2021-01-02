package io.devfactory.designpattern.behavior.memento;

import io.devfactory.designpattern.behavior.memento.service.Hello;

import java.util.ArrayDeque;
import java.util.Deque;

public class CareTaker {

  protected Deque<Memento> mementos;

  // 케어테이커 생성자
  public CareTaker() {
    mementos = new ArrayDeque<>();
  }

  // 스택을 저장
  public void push(Originator originator) {
    // 원조본을 이용하여 메멘토의 인스턴스를 생성
    final Memento memento = originator.create();

    // 메멘토를 스택에 저장
    mementos.push(memento);
  }

  // 스택에서 객체를 읽어옴
  public Hello undo(Originator originator) {
    // 스택에서 메멘토를 읽어옴
    final Memento memento = mementos.pop();
    
    // 메멘토를 이용하여 원조본을 복원
    originator.restore(memento);
    
    // 복원된 객체를 반환
    return originator.getState();
  }

}
