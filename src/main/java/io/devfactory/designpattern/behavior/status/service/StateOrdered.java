package io.devfactory.designpattern.behavior.status.service;

import io.devfactory.designpattern.behavior.status.State;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StateOrdered implements State {

  @Override
  public void process() {
    log.debug("주문완료");
  }
  
}
