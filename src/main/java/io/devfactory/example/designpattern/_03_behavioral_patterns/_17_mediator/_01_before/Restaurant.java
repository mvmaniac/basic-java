package io.devfactory.example.designpattern._03_behavioral_patterns._17_mediator._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Restaurant {

  private final CleaningService cleaningService = new CleaningService();

  public void dinner(Guest guest) {
    log.debug("dinner {}", guest);
  }

  public void clean() {
    cleaningService.clean(this);
  }

}
