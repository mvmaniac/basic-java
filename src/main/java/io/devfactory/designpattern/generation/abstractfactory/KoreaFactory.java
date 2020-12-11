package io.devfactory.designpattern.generation.abstractfactory;

import io.devfactory.designpattern.generation.abstractfactory.service.DoorProduct;
import io.devfactory.designpattern.generation.abstractfactory.service.KoreaDoorProduct;
import io.devfactory.designpattern.generation.abstractfactory.service.KoreaTireProduct;
import io.devfactory.designpattern.generation.abstractfactory.service.TireProduct;
import lombok.extern.slf4j.Slf4j;

// 한국 공장 팩토리
@Slf4j
public class KoreaFactory extends Factory {

  public KoreaFactory() {
    log.debug("KoreaFactory 를 생성합니다.");
  }

  @Override
  public TireProduct createTire() {
    return new KoreaTireProduct();
  }

  @Override
  public DoorProduct createDoor() {
    return new KoreaDoorProduct();
  }

}
