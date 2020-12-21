package io.devfactory.designpattern.structure.bridge.service;

// 한글 인사말 (ConcreateImplementor)
public class Korean implements Hello {

  @Override
  public String greeting() {
    return "안녕하세요";
  }

}
