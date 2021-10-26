package io.devfactory.example.designpattern.structure.bridge;

import io.devfactory.example.designpattern.structure.bridge.service.Hello;

// 추상 클래스를 연결할 수 있는 프로퍼티와 인터페이스의 추상 메서드만 선언 (Abstract)
public abstract class Language {

  protected Hello hello;

  public abstract String greeting(); // 추상 메서드

}
