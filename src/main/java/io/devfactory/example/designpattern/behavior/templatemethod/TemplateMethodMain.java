package io.devfactory.example.designpattern.behavior.templatemethod;

import io.devfactory.example.designpattern.behavior.templatemethod.service.Sandwich;
import io.devfactory.example.designpattern.behavior.templatemethod.service.Strawberry;
import io.devfactory.example.designpattern.behavior.templatemethod.service.StrawberryBagel;
import lombok.extern.slf4j.Slf4j;

// 템플릿 메서드 패턴 (Template Method Pattern)
// 메서드를 이용해 각 단계를 템플릿 구조화하고 행동을 구분
// 클래스의 일반화(generalization)는 공통점을 찾아 상위 클래스로 도출하는 과정으로
// 공통된 부분은 상위 클래스로, 다른 클래스는 하위 클래스로 재설계함
// 템플릿 메서드 패턴은 추상 클래스를 통해 상속을 추상화함
// 메서드는 상위 클래스에 공통적 기능만 구현하고, 변경되는 부분은 추상 메서드로 선언
// 템플릿 메서드에서 처리하는 템플릿은 전략 패턴에서 구현하는 알고리즘와 유사한데
// 템플릿 메서드 패턴은 알고리즘의 동작 일부를 변경하지만 전략 패턴은 알고리즘 동작 전체를 변경
@Slf4j
public class TemplateMethodMain {

  public static void main(String[] args) {
    log.debug("배고프다. 샌드위치를 만든다.");

    Sandwich sandwich = new Strawberry();
    log.debug("{}", sandwich.make());

    log.debug("");

    log.debug("배고프다. 다른 샌드위치를 만든다.");

    sandwich = new StrawberryBagel();
    log.debug("{}", sandwich.make());
  }

}
