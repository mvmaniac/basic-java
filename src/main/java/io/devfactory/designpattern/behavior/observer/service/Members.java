package io.devfactory.designpattern.behavior.observer.service;

import io.devfactory.designpattern.behavior.observer.Observer;
import io.devfactory.designpattern.behavior.observer.Subject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

// 실제적 주체 구현
@Slf4j
public class Members implements Subject {

  private final List<Observer> observers;

  public Members() {
    log.debug("Members 실제 주체(concreteSubject)를 생성합니다.");
    this.observers = new ArrayList<>();
  }

  // 감시자를 등록함
  @Override
  public void addObserver(Observer observer) {
    log.debug("감시자를 추가합니다. {}", observer.getName());
    observers.add(observer);
  }

  // 감시자를 제거함
  @Override
  public void deleteObserver(Observer observer) {
    log.debug("감시자를 제거합니다. {}", observer.getName());
    observers.removeIf(o -> o.getName().equals(observer.getName()));
  }

  @Override
  public void notifyObserver() {
    observers.forEach(Observer::update);
  }

}
