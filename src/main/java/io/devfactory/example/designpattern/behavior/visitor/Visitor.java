package io.devfactory.example.designpattern.behavior.visitor;

// 방문자
public interface Visitor {

  String order(Visitable visitable);

}
