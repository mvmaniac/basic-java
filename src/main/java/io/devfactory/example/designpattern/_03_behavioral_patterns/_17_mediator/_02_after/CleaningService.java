package io.devfactory.example.designpattern._03_behavioral_patterns._17_mediator._02_after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CleaningService {

  private final FrontDesk frontDesk = new FrontDesk();

  public void getTowers(Integer guestId, int numberOfTowers) {
    String roomNumber = this.frontDesk.getRoomNumberFor(guestId);
    log.debug("provide {} to {}", numberOfTowers, roomNumber);
  }

}
