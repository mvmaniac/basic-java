package io.devfactory.designpattern.generation.abstractfactory.service;

import lombok.extern.slf4j.Slf4j;

// 추상 클래스 적용
// 한국 규격 타이어
@Slf4j
public class KoreaTireProduct extends TireProduct {

  public KoreaTireProduct() {
    log.debug("KoreaTireProduct 객체를 생성합니다.");
  }

  @Override
  public void makeAssemble() {
    log.debug("메서드 호출 KoreaTireProduct.makeAssemble");
    log.debug("한국형 타이어 장착");
  }

}
