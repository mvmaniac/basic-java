package io.devfactory.example.designpattern._03_behavioral_patterns._17_mediator._02_after;

import java.time.LocalDateTime;

public class FrontDesk {

  private final CleaningService cleaningService = new CleaningService();
  private final Restaurant restaurant = new Restaurant();

  public void getTowers(Guest guest, int numberOfTowers) {
    cleaningService.getTowers(guest.getId(), numberOfTowers);
  }

  public String getRoomNumberFor(Integer guestId) {
    return "1111";
  }

  public void dinner(Guest guest, LocalDateTime dateTime) {
    restaurant.dinner(guest.getId(), dateTime);
  }

}
