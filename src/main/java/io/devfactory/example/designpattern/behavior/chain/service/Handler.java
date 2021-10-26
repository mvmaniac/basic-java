package io.devfactory.example.designpattern.behavior.chain.service;

import io.devfactory.example.designpattern.behavior.chain.Chain;

// 분리된 실제 동작 객체를 핸들러 객체와 결합
// 핸들러는 전송 받은 상태값에 따라 객체를 생성하고 메시지를 출력
public class Handler {

  public String event(String event) {
    // 체인 설정
    final Chain first = new Order();
    first.setNext(new Cancel());

    return first.execute(event);
  }

}
