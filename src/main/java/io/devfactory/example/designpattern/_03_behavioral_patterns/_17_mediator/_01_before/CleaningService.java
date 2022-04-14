package io.devfactory.example.designpattern._03_behavioral_patterns._17_mediator._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CleaningService {

  public void clean(Gym gym) {
    log.debug("clean {}", gym);
  }

  public void getTower(Guest guest, int numberOfTower) {
    log.debug("{} towers to {}", numberOfTower, guest);
  }

  public void clean(Restaurant restaurant) {
    log.debug("clean {}", restaurant);
  }

}
