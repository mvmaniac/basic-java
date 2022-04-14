package io.devfactory.example.designpattern._03_behavioral_patterns._17_mediator._02_after;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Guest {

  private final FrontDesk frontDesk = new FrontDesk();
  private Integer id;

  public void getTowers(int numberOfTowers) {
    this.frontDesk.getTowers(this, numberOfTowers);
  }

  private void dinner(LocalDateTime dateTime) {
    this.frontDesk.dinner(this, dateTime);
  }

}
