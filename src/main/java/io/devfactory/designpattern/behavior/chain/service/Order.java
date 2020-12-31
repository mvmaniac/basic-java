package io.devfactory.designpattern.behavior.chain.service;

import io.devfactory.designpattern.behavior.chain.Chain;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

// 분리된 실제 동작 객체
@Slf4j
public class Order extends Chain {

  public String execute(String event) {
    log.debug("Order 실행");

    if (Objects.equals(event, "order")) {
      return "주문을 처리합니다.";
    }

    return this.canExecute() ? this.next.execute(event) : "";
  }

}
