package io.devfactory.example.designpattern.behavior.visitor.service;

import io.devfactory.example.designpattern.behavior.visitor.Visitable;
import io.devfactory.example.designpattern.behavior.visitor.Visitor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

// 방문 조사
@Slf4j
@Getter
public class Visitant implements Visitor {

  // 상태 값
  private int total;
  private int num;

  public Visitant() {
    log.debug("주문을 처리합니다.");
    total = 0;
    num = 0;
  }

  // 원소 객체를 전달 받음
  @Override
  public String order(Visitable visitable) {
    log.debug("== 상품 내역 ==");

    // 방문자를 확인
    if (visitable instanceof Cart) {
      Cart cart = (Cart) visitable;

      int total = cart.getPrice() * cart.getNum();
      this.total += total;

      // 주문건수 증가
      this.num += 1;

      String message =
          """
          상품명: %s, 수량: %s, 가격: %d 입니다.
          합계: %d
          """;

      String result = message.formatted(cart.getName(), cart.getNum(), total, this.total);
      log.debug("\n{}", result);

      return result;
    }

    return "";
  }

}
