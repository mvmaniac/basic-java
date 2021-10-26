package io.devfactory.example.designpattern.structure.bridge.service;

// 영어 인사말 (ConcreateImplementor)
public class English implements Hello {

  @Override
  public String greeting() {
    return "Hello.";
  }

}
