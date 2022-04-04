package io.devfactory.example.designpattern._01_creational_patterns._01_singleton;

// static inner 클래스 사용
public final class Settings {

  private Settings() {
    // nothing
  }

  @SuppressWarnings({"InstantiationOfUtilityClass", "squid:S2440"})
  private static class SettingsHolder {

    public static final Settings INSTANCE = new Settings();

  }

  public static Settings getInstance() {
    return SettingsHolder.INSTANCE;
  }

}
