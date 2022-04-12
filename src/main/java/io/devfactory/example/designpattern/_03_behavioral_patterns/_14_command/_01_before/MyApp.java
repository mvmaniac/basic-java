package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._01_before;

@SuppressWarnings("ClassCanBeRecord")
public class MyApp {

  private final Game game;

  public MyApp(Game game) {
    this.game = game;
  }

  public void press() {
    game.start();
  }

}
