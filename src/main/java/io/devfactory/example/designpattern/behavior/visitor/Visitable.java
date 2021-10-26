package io.devfactory.example.designpattern.behavior.visitor;

// 방문을 받아들이는 인터페이스
public interface Visitable {

  String accept(Visitor visitor);

}
