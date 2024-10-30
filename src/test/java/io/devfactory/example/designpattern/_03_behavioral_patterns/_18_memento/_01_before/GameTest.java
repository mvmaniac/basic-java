package io.devfactory.example.designpattern._03_behavioral_patterns._18_memento._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("squid:S1186")
@Slf4j
class GameTest {

  @DisplayName("변경 전 메멘토 패턴 테스트")
  @Test
  void testMemento() {
    Game game = new Game();
    game.setRedTeamScore(10);
    game.setBlueTeamScore(20);

    int blueTeamScore = game.getBlueTeamScore();
    int redTeamScore = game.getRedTeamScore();

    Game restoredGame = new Game();
    restoredGame.setBlueTeamScore(blueTeamScore);
    restoredGame.setRedTeamScore(redTeamScore);
  }

}
