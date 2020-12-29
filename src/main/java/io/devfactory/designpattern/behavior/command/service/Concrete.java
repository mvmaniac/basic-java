package io.devfactory.designpattern.behavior.command.service;

import lombok.extern.slf4j.Slf4j;

//실제 명령
@Slf4j
public class Concrete {

  public void action1() {
    log.debug("동작1: 안녕하세요.");
  }

  public void action2() {
    log.debug("동작2: 즐거운 시간 되세요");
  }

}
