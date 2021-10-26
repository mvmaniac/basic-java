package io.devfactory.example.designpattern.behavior.chain.service;

import io.devfactory.example.designpattern.behavior.chain.Chain;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

// 분리된 실제 동작 객체
@Slf4j
public class Cancel extends Chain {

  public String execute(String event) {
    log.debug("Cancel 실행");
    
    if (Objects.equals(event, "cancel")) {
      return "주문을 취소합니다.";
    }

    return this.canExecute() ? this.next.execute(event) : "";
  }

}
