package io.devfactory.designpattern.structure.facade.service;

import lombok.extern.slf4j.Slf4j;

// 기능2 클래스를 선언
@Slf4j
public class Package2 {

  public Package2() {
    log.debug("Package2 객체가 생성 되었습니다.");
  }

  public void process() {
    log.debug("패키지2 작업을 진행합니다.");
  }

}
