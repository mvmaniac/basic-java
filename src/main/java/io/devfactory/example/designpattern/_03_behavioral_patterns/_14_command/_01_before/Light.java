package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Light {

  private boolean isOn;

  public void on() {
    log.debug("불을 켭니다.");
    this.isOn = true;
  }

  public void off() {
    log.debug("불을 끕니다.");
    this.isOn = false;
  }

  public boolean isOn() {
    return this.isOn;
  }

}
