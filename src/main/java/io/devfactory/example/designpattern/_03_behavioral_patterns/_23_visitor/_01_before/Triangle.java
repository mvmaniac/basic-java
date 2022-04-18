package io.devfactory.example.designpattern._03_behavioral_patterns._23_visitor._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Triangle implements Shape {

  @Override
  public void printTo(Device device) {
    if (device instanceof Phone) {
      log.debug("print Triangle to Phone");
    } else if (device instanceof Watch) {
      log.debug("print Triangle to Watch");
    }
  }

}
