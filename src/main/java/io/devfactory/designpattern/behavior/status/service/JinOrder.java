package io.devfactory.designpattern.behavior.status.service;

import io.devfactory.designpattern.behavior.status.State;

import java.util.Map;

public class JinOrder {

  private final Map<String, State> stateMap;

  // 객체 초기화
  public JinOrder() {
    this.stateMap = Map.ofEntries(
        Map.entry("ORDER", new StateOrder()),
        Map.entry("PAY", new StatePay()),
        Map.entry("ORDERED", new StateOrdered()),
        Map.entry("FINISH", new StateFinish())
    );
  }

  // 상태의 서브 클래스를 호출
  public void process(String status) {
    if (stateMap.containsKey(status)) {
      stateMap.get(status).process();
    }
  }

}
