package io.devfactory.example.designpattern.behavior.chain;

import io.devfactory.example.designpattern.behavior.chain.service.Handler;
import lombok.extern.slf4j.Slf4j;

// 체인 패턴 (Chain Pattern)
// 객체 메세지의 송신과 수신을 분리해서 처리
// 체친 패턴의 아이디어는 핸들러에서 순차적으로 이벤트를 검사하는 조건들을 분리하는 것
// 핸들러 객체에서 검사하던 조건 처리 로직이 분리된 실제 동작 객체로 이동 시킴
// 핸들러 객체 안에 있는 조건 처리 로직을 분리하면, 핸들러는 단일 책임 원칙을 유지할 수 있음
// 하나의 상태값에 여러 객체를 묶어 실행 하는 방법으로
// 이벤트의 조건에 맞는 행동을 찾을 필요가 없음
// 처음 객체부턴 순차적으로 자신에게 맞는 행동을 판단하고 실행을 계속함
// 자신의 객체가 처리할 수 있는 상태값이면 동작을 실행하고, 자신의 객체와 맞지 않는 상태값이면 다음 객체로 행동을 위힘함
// 순차적으로 모든 객체를 처리하기 때문에 다소 지연 시간이 발생함
@Slf4j
public class ChainMain {

  public static void main(String[] args) {
    final Handler handler = new Handler();
    log.debug("{}", handler.event("order"));
  }


}
