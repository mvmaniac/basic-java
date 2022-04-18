package io.devfactory.example.designpattern._03_behavioral_patterns._23_visitor._02_after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Phone implements Device {

  @Override
  public void print(Circle circle) {
    log.debug("Print Circle to Phone");
  }

  @Override
  public void print(Rectangle rectangle) {
    log.debug("Print Rectangle to Phone");
  }

  @Override
  public void print(Triangle triangle) {
    log.debug("Print Triangle to Phone");
  }

}
