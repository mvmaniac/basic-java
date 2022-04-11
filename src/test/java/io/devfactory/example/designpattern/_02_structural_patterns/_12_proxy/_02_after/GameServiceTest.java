package io.devfactory.example.designpattern._02_structural_patterns._12_proxy._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class GameServiceTest {

  @DisplayName("변경 후 프록시 패턴 테스트")
  @Test
  void testProxy() {
    GameService gameService = new GameServiceProxy();
    gameService.startGame();
  }

}
