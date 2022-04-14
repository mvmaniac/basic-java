package io.devfactory.example.designpattern._03_behavioral_patterns._18_memento._02_after;

import lombok.Getter;

@SuppressWarnings("ClassCanBeRecord")
@Getter
public final class GameSave {

  private final int blueTeamScore;
  private final int redTeamScore;

  public GameSave(int blueTeamScore, int redTeamScore) {
    this.blueTeamScore = blueTeamScore;
    this.redTeamScore = redTeamScore;
  }

}
