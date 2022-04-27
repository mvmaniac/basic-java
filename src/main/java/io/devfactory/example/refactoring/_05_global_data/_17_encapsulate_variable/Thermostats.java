package io.devfactory.example.refactoring._05_global_data._17_encapsulate_variable;

@SuppressWarnings({"squid:S1444", "squid:S1104"})
public class Thermostats {

  private Thermostats() {
    throw new IllegalStateException("Constructor does not support creation");
  }

  private static final Boolean HEATING = true;

  private static final Boolean COOLING = false;

  private static Boolean readInFahrenheit = true;

  private static Integer targetTemperature = 70;


  public static Boolean getReadInFahrenheit() {
    return readInFahrenheit;
  }

  public static void setReadInFahrenheit(Boolean readInFahrenheit) {
    Thermostats.readInFahrenheit = readInFahrenheit;
  }

  public static Integer getTargetTemperature() {
    return targetTemperature;
  }

  public static void setTargetTemperature(Integer targetTemperature) {
    Thermostats.targetTemperature = targetTemperature;
  }

}
