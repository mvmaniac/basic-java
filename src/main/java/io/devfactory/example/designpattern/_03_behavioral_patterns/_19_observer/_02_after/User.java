package io.devfactory.example.designpattern._03_behavioral_patterns._19_observer._02_after;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("ClassCanBeRecord")
@Slf4j
@Getter
public class User implements Subscriber {

  private final String name;

  public User(String name) {
    this.name = name;
  }

  @Override
  public void handleMessage(String message) {
    log.debug(message);
  }

}
