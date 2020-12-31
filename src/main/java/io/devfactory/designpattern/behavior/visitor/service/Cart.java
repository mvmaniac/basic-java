package io.devfactory.designpattern.behavior.visitor.service;

import io.devfactory.designpattern.behavior.visitor.Visitable;
import io.devfactory.designpattern.behavior.visitor.Visitor;

// 원소 객체
public class Cart extends Product implements Visitable {

  public Cart(String name, int price, int num) {
    this.name = name;
    this.price = price;
    this.num = num;
  }

  public int getTax(int tax) {
    return (price * num) * (tax / 100);
  }

  public String list() {
    return String.format("%s, 수량=%d, 가격=%d 입니다.", name, num, price * num);
  }

  // 인터페이스 구현
  @Override
  public String accept(Visitor visitor) {
    // 방문자의 주문을 호출
    // 인자로 원소 객체 자신을 전달함
    return visitor.order(this);
  }

}
