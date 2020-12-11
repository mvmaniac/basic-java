package io.devfactory.designpattern.generation.abstractfactory.service;

import lombok.extern.slf4j.Slf4j;

// 추상 클래스 적용
// 미국 규격 도어
@Slf4j
public class StateDoorProduct extends DoorProduct {

  public StateDoorProduct() {
    log.debug("StateDoorProduct 객체를 생성합니다.");
  }

  @Override
  public void makeAssemble() {
    log.debug("메서드 호출 StateDoorProduct.makeAssemble");
    log.debug("미국형 도어 장착");
  }

}
