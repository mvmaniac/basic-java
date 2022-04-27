package io.devfactory.example.refactoring._05_global_data._17_encapsulate_variable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Home {

  public static void main(String[] args) {
    log.debug("{}", Thermostats.getTargetTemperature());
    Thermostats.setTargetTemperature(68);
    Thermostats.setReadInFahrenheit(false);
  }

}
