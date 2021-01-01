package io.devfactory.designpattern.behavior.observer;

// 주체의 인터페이스를 선언
public interface Subject {

  void addObserver(Observer observer);
  void deleteObserver(Observer observer);
  void notifyObserver();

}
