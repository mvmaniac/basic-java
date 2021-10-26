package io.devfactory.example.designpattern.structure.adapter.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Math {

  // 입력한 값이 2배 증가
  public double towTime(double num) {
    log.debug("실수 2배 적용합니다.");
    return num * 2;
  }

  // 입력 한 값이 절반으로 감소
  public double halfTime(double num) {
    log.debug("실수 1/2배 적용합니다.");
    return num / 2;
  }

}
