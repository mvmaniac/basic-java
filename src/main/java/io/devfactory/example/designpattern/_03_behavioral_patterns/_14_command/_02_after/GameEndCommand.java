package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._02_after;

import io.devfactory.example.designpattern._03_behavioral_patterns._14_command._01_before.Game;

public class GameEndCommand implements Command {

  private final Game game;

  public GameEndCommand(Game game) {
    this.game = game;
  }

  @Override
  public void execute() {
    game.end();
  }

  @Override
  public void undo() {
    new GameStartCommand(game).execute();
  }

}
