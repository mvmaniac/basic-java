package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {

  private boolean isStarted;

  public void start() {
    log.debug("게임을 시작합니다.");
    this.isStarted = true;
  }

  public void end() {
    log.debug("게임을 종료합니다.");
    this.isStarted = false;
  }

  public boolean isStarted() {
    return isStarted;
  }

}
