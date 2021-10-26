package io.devfactory.example.designpattern.generation.abstractfactory.service;

import lombok.extern.slf4j.Slf4j;

// 추상 클래스 적용
// 미국 규격 타이어
@Slf4j
public class StateTireProduct extends TireProduct {

  public StateTireProduct() {
    log.debug("StateDoorProduct 객체를 생성합니다.");
  }

  @Override
  public void makeAssemble() {
    log.debug("메서드 호출 StateTireProduct.makeAssemble");
    log.debug("미국형 타이어 장착");
  }

}
