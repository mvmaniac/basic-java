package io.devfactory.example.designpattern._02_structural_patterns._12_proxy._02_after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameServiceProxy implements GameService {

  private GameService gameService;

  @Override
  public void startGame() {
    long before = System.currentTimeMillis();
    if (this.gameService == null) {
      this.gameService = new DefaultGameService();
    }

    gameService.startGame();
    log.debug("{}", System.currentTimeMillis() - before);
  }

}
