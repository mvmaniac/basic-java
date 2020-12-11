package io.devfactory.designpattern.generation.abstractfactory;

import io.devfactory.designpattern.generation.abstractfactory.service.DoorProduct;
import io.devfactory.designpattern.generation.abstractfactory.service.StateDoorProduct;
import io.devfactory.designpattern.generation.abstractfactory.service.StateTireProduct;
import io.devfactory.designpattern.generation.abstractfactory.service.TireProduct;
import lombok.extern.slf4j.Slf4j;

// 미국 공장 팩토리
@Slf4j
public class StateFactory extends Factory {

  public StateFactory() {
    log.debug("StateFactory 를 생성합니다.");
  }

  @Override
  public TireProduct createTire() {
    return new StateTireProduct();
  }

  @Override
  public DoorProduct createDoor() {
    return new StateDoorProduct();
  }

}
