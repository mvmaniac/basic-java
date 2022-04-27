package io.devfactory.example.refactoring._05_global_data._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Home {

  public static void main(String[] args) {
    log.debug("{}", Thermostats.targetTemperature);
    Thermostats.targetTemperature = -1111600;
    Thermostats.fahrenheit = false;
  }

}
