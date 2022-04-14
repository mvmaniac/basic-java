package io.devfactory.example.designpattern._03_behavioral_patterns._18_memento._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class GameTest {

  @DisplayName("변경 후 메멘토 패턴 테스트")
  @Test
  void testMemento() {
    Game game = new Game();
    game.setBlueTeamScore(10);
    game.setRedTeamScore(20);

    GameSave save = game.save();

    game.setBlueTeamScore(12);
    game.setRedTeamScore(22);

    game.restore(save);

    log.debug("blueTeamScore: {}", game.getBlueTeamScore());
    log.debug("redTeamScore: {}", game.getRedTeamScore());
  }

}
