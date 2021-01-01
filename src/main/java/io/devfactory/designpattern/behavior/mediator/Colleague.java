package io.devfactory.designpattern.behavior.mediator;

public abstract class Colleague {

  protected Mediator<?> mediator;
  
  // 중개 객체를 설정
  // concreteMediator 에 의해서 호출 됨
  public void changeMediator(Mediator<?> mediator) {
    this.mediator = mediator;
  }

}
