package io.devfactory.designpattern.behavior.status;

public interface LightState {

  LightState lightOn();
  LightState lightOff();
  boolean lightState();

}
