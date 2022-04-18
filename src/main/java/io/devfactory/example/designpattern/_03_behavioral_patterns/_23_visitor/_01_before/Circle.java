package io.devfactory.example.designpattern._03_behavioral_patterns._23_visitor._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Circle implements Shape {

  @Override
  public void printTo(Device device) {
    if (device instanceof Phone) {
      log.debug("print Circle to phone");
    } else if (device instanceof Watch) {
      log.debug("print Circle to watch");
    }
  }

}
