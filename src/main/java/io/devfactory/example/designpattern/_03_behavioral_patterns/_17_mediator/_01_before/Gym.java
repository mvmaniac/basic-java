package io.devfactory.example.designpattern._03_behavioral_patterns._17_mediator._01_before;

public class Gym {

  private final CleaningService cleaningService = new CleaningService();

  public void clean() {
    cleaningService.clean(this);
  }

}
