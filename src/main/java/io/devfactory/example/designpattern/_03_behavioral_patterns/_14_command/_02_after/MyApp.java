package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._02_after;

@SuppressWarnings("ClassCanBeRecord")
public class MyApp {

  private final Command command;

  public MyApp(Command command) {
    this.command = command;
  }

  public void press() {
    command.execute();
  }

}
