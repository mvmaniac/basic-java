package io.devfactory.example.refactoring._05_global_data._01_before;

@SuppressWarnings({"squid:S1444","squid:S1104"})
public class Thermostats {

  private Thermostats() {
    throw new IllegalStateException("Constructor does not support creation");
  }

  public static final Boolean HEATING = true;

  public static final Boolean COOLING = false;

  public static Boolean fahrenheit = true;

  public static Integer targetTemperature = 70;

}
