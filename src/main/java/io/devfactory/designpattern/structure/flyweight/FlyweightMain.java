package io.devfactory.designpattern.structure.flyweight;

import lombok.extern.slf4j.Slf4j;

// 플라이웨이트 패턴 (Flyweight Pattern)
// 겍체를 공유하기 위해 구조를 변경하는 패턴으로 객체를 공유하면 객체를 재사용할 수 있어 시스템 자원이 절약됨
// 중복을 제거하고 공유을 통해 자원을 효율적으로 사용
// 중복되는 코드의 객체를 공유함으로써 객체의 메모리 할당을 작게 처리
// 중복된 객체를 개별적으로 상속하거나 생성하지 않고 자원을 재사용함으로써 호율을 개선
// 객체를 공유하기 위한 패턴으로 중복되는 객체를 매번 생성하는 것이 아니라 생성된 객체를 공유하여 재사용하는 방법을 제시
// 해당 패턴으로 공유되는 객체는 사이드 이펙트 문제에 노출될 확률이 높음
// 공유 객체는 새로 생성된 객체가 아니라 기존의 객체를 참조하는 객체이기 때문
@Slf4j
public class FlyweightMain {

  public static void main(String[] args) {
    final Factory factory = new Factory();
    
    String name = "goooogllleee";
    log.debug("원본 이름 = {}", name);

    for (int i = 0; i < name.length(); i++) {
      final String code = String.valueOf(name.charAt(i));
      log.debug("{} => {}", code, factory.getCode(code).code());
    }
  }

}
