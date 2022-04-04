package io.devfactory.example.designpattern._01_creational_patterns._02_factory_method._02_after;

import lombok.extern.slf4j.Slf4j;

// ShipFactory에 private 메소드를 정의해서 할 경우 DefaultShipFactory는 필요 없음
// 다만 Java 8 이하 인 경우 중간에 추상클래스가 필요함
// 일단 @Slf4j가 interface에서는 안되서 추상클래스를 만듬 
@Slf4j
public abstract class DefaultShipFactory implements ShipFactory {

  @Override
  public void prepareFor(String name) {
    log.debug("{} 만들 준비 중", name);
  }

  @Override
  public void sendEmailTo(String email, Ship ship) {
    log.debug("{} 다 만들었습니다.", ship.getName());
  }

}
