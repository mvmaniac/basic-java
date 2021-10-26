package io.devfactory.example.designpattern.behavior.status.service;

import io.devfactory.example.designpattern.behavior.status.State;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StateFinish implements State {

  @Override
  public void process() {
    log.debug("처리완료");
  }

}
