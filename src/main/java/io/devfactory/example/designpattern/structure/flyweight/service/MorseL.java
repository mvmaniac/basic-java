package io.devfactory.example.designpattern.structure.flyweight.service;

import io.devfactory.example.designpattern.structure.flyweight.Flyweight;
import lombok.extern.slf4j.Slf4j;

// 본질적 상태의 공유객체, 본질적 공유 상태를 유지하기 위해 변수가 존재하지 않음
// 따라서 객체의 상탯값 변경에 따라 영향을 받는 사이드 이펙트가 발생하지 않음
@Slf4j
public class MorseL implements Flyweight {

  public MorseL() {
    log.debug("MorseL 을(를) 생성하였습니다.");
  }

  @Override
  public String code() {
    return "*-**";
  }

}
