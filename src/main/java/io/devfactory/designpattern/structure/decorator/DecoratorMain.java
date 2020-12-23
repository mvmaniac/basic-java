package io.devfactory.designpattern.structure.decorator;

import io.devfactory.designpattern.structure.decorator.service.Component;
import io.devfactory.designpattern.structure.decorator.service.Product1;
import lombok.extern.slf4j.Slf4j;

// 장식자 패턴 (Decorator Pattern)
// 객체에 동적 기능을 추가하기 위해 구조를 개선하는 패턴, 다양한 확장을 위해 객체를 조합
// 새로운 기능을 추가하기 위해 클래스를 확장하는 방법은 상속과 구성 두가지
// 상속은 클래스를 확장하는 대표적인 구현 기법 이지만 상위 클래스와 하위 클래스 간에 강력한 걸합 관계가 생성됨
// 이러한 강력한 결합은 유연한 확장을 어렵게 만드며 또한 기존 객체에 새로운 기능을 추가할 때마다 메서드를 오버라이드하여 변경해야 함
// 상속은 정적 방식으로 기능을 확장하기 때문에, 객체를 상황에 맞게 동적으로 확장해야 할 경우 상속으로 구현하는 것이 쉽지 않음
// 구성은 위임을 활용해 객체를 확장하는 방법으로 객체를 실행하는 도중에 동적으로 다른 객체를 결합해 확장 가능 함
// 장식자 패턴은 동적으로 객체를 결합하기 위해서 객체지향의 구성을 통해 확장
// 장식자 패턴은 4개의 구성 요소로 이루어짐
// Component: 인터페이스를 정의
// ConcreateComponent: 인터페이스에 정의 실제를 구현
// Decorator: 컴포넌트를 참조하여 인터페이스를 일치화
// ConcreateDecorator: 확장 및 추가되는 기능을 작성
// 기존의 객체에 영향을 주지 않고 새로운 기능을 동적으로 추가
// 복합체 패턴과의 차이는 객체를 합성 하는 것이 아닌 새로운 객체의 행동을 추가하는 것이라고 할 수 있음
// 복합체 패턴의 경우 좌우 폭, 상하 관계 등 다양한 형태의 크기로 확장 될 수 있으나 장식자 패턴은 상하 계층으로만 확장됨
@Slf4j
public class DecoratorMain {

  public static void main(String[] args) {
    final Product1 product1 = new Product1();

    Component spec;
    spec = new i7(product1);
    spec = new ssd256(spec);

    log.debug("스펙: {}", spec.product());
    log.debug("가격: {}", spec.price());
  }

}
