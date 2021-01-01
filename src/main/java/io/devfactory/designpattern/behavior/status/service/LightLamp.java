package io.devfactory.designpattern.behavior.status.service;

import io.devfactory.designpattern.behavior.status.LightState;
import lombok.extern.slf4j.Slf4j;

// 객체를 구현
@Slf4j
public class LightLamp implements LightState {

  // private 속성을 이용하여
  // 외부에서 상태에 직접 접근 할 수 없도록 정의
  private boolean lightState;

  public LightLamp() {
    log.debug("LightLamp 객체를 생성합니다.");

    // 전구의 초기 상태는 off 입니다.
    lightState = false;
  }

  // 전구(LED)를 on 합니다.
  @Override
  public LightState lightOn() {
    log.debug("전구를 on 합니다.");
    lightState = true;
    return this;
  }

  // 전구(LED)를 off 합니다.
  @Override
  public LightState lightOff() {
    log.debug("전구를 off 합니다.");
    lightState = false;
    return this;
  }

  // 전구(LED)를 상태값을 반환 합니다.
  @Override
  public boolean lightState() {
    return lightState;
  }

}
