package io.devfactory.designpattern.structure.facade.service;

import lombok.extern.slf4j.Slf4j;

// 기능1 클래스를 선언
@Slf4j
public class Package1 {

  public Package1() {
    log.debug("Package1 객체가 생성 되었습니다.");
  }

  public void process() {
    log.debug("패키지1 작업을 진행합니다.");
  }

}
