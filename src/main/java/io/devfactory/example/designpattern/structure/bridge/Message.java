package io.devfactory.example.designpattern.structure.bridge;

import io.devfactory.example.designpattern.structure.bridge.service.Hello;

// 추상 클래스를 상속 (refinedAbstract)
public class Message extends Language {

  public Message(Hello hello) {
    this.hello = hello;
  }

  @Override
  public String greeting() {
    // 브리지 구현
    return this.hello.greeting(); // 분리된 역할 담당
  }

}
