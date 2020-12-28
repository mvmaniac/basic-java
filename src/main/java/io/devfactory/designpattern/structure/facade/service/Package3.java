package io.devfactory.designpattern.structure.facade.service;

import lombok.extern.slf4j.Slf4j;

// 기능3 클래스를 선언
@Slf4j
public class Package3 {

  public Package3() {
    log.debug("Package3 객체가 생성 되었습니다.");
  }

  public void process() {
    log.debug("패키지3 작업을 진행합니다.");
  }

}
