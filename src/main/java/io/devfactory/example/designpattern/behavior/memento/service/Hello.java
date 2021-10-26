package io.devfactory.example.designpattern.behavior.memento.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Hello {

  private String message;

  public Hello(String message) {
    this.message = message;
  }

  // 복제용 생성자를 추가해서 복제하는 방식으로 내가 추가함...
  public Hello(Hello hello) {
    this.message = hello.getMessage();
  }

}
