package io.devfactory.designpattern.behavior.strategy;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

// 객체를 델리게이트 처리하여 호출
@Slf4j
public class Character extends Strategy {

  @Override
  public void attack() {
    if (Objects.isNull(delegate)) {
      // 무기가 선택되지 않은 경우
      log.debug("맨손 공격합니다.");
      return;
    }

    delegate.attack();
  }

}
