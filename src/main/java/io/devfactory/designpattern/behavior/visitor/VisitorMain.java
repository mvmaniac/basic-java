package io.devfactory.designpattern.behavior.visitor;

import io.devfactory.designpattern.behavior.visitor.service.Cart;
import io.devfactory.designpattern.behavior.visitor.service.Visitant;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

// 방문자 패턴 (Visitor Pattern)
// 공통된 객체의 데이터 구조와 처리르 분리하는 패턴
// 분산된 객체에서 공통된 처리 로직만 분리하고 분리한 공통된 로직 구조를 별도의 객체로 
// 방문자는 객체지향의 OCP 원칙을 반영한 패턴이고, 방문자 패턴은 데이터 치리 행위를 위해 객체를 분리
// 방문자 패턴에서 원소 객체는 데이터를 보관하는 구조 클래스
// 모든 원소 객체는 위임을 위해 인터페이스에 선언된 accept() 메서드를 구현하며, 
// accept() 메서드는 매개변수를 통해 위임되는 객체를 전달 받음
// 방문자 패턴은 새로운 행위가 추가돼도 기존 객체를 변경하지 않고 추가 행위를 구현 할 수 있음
// 왜냐하면 구체적인 작업을 방문자 객체가 처리하도록 위임하기 때문
// 하지만 방문자 패턴은 방문하는 외부 객체에 자신의 모든 데이터와 행위의 접근을 허용함
// 객체지향의 장점인 캡슐화와 데이터 은닉을 활용할 수 없게 방해하는 요인
// 방문자 패턴의 2개의 인터페이스와 2개의 구현체를 만듬
@Slf4j
public class VisitorMain {

  public static void main(String[] args) {
    log.debug("쇼핑몰 상품 주문 처리");

    // 공통된 방문자 객체
    final Visitant visitant = new Visitant();

    // 방문객이 방문자를 하나씩
    final List<Cart> carts = List.of(
        new Cart("컵라면", 900, 3),
        new Cart("컵라면", 1500, 1),
        new Cart("컵라면", 2800, 1)
    );

    carts.forEach(cart -> cart.accept(visitant));

    log.debug("감사합니다. 주문건수: {}", visitant.getNum());
    log.debug("주문합계: {} 입니다.", visitant.getTotal());
  }

}
