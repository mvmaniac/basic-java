package io.devfactory.example.designpattern._02_structural_patterns._12_proxy._02_after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultGameService implements GameService {

  @Override
  public void startGame() {
    log.debug("이 자리에 오신 여러분을 진심으로 환영합니다.");
  }

}
