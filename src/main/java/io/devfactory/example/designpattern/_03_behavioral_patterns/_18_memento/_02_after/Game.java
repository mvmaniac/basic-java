package io.devfactory.example.designpattern._03_behavioral_patterns._18_memento._02_after;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Game {

  private int redTeamScore;
  private int blueTeamScore;

  public GameSave save() {
    return new GameSave(this.blueTeamScore, this.redTeamScore);
  }

  public void restore(GameSave gameSave) {
    this.blueTeamScore = gameSave.getBlueTeamScore();
    this.redTeamScore = gameSave.getRedTeamScore();
  }

}
