package io.devfactory.designpattern.generation.factory.service;

import io.devfactory.designpattern.generation.factory.Factory;
import io.devfactory.designpattern.generation.factory.service.greeting.Greeting;
import io.devfactory.designpattern.generation.factory.service.greeting.Language;

public class Hello {

  public String greeting(Language language) {
    // new 키워드를 직접 사용하지 않고 Factory 클래스 getInstance() 메서드가 객체를 생성해서 반환
    // Factory 클래스는 객체의 생성 작업을 위임하는 역할을 수행
    final Greeting instance = Factory.getInstance(language);
    return instance.text();
  }

}
