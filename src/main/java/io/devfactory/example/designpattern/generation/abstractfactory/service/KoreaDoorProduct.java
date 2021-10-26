package io.devfactory.example.designpattern.generation.abstractfactory.service;

import lombok.extern.slf4j.Slf4j;

// 추상 클래스 적용
// 한국 규격 도어
@Slf4j
public class KoreaDoorProduct extends DoorProduct {

  public KoreaDoorProduct() {
    log.debug("KoreaDoorProduct 객체를 생성합니다.");
  }

  @Override
  public void makeAssemble() {
    log.debug("메서드 호출 KoreaDoorProduct.makeAssemble");
    log.debug("한국형 도어 장착");
  }

}
