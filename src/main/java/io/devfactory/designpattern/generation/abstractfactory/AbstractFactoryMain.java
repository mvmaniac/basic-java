package io.devfactory.designpattern.generation.abstractfactory;

import io.devfactory.designpattern.generation.abstractfactory.service.DoorProduct;
import io.devfactory.designpattern.generation.abstractfactory.service.TireProduct;

// 추상 택토리 패턴 (Abstract Factory Pattern)
// 팩토리 메서드는 추상 클래스와 하위 클래스를 1개로만 구성하며,
// 추상 팩토리와 동일하게 추상화 과정을 적용할 수 있지만 단일 그룹으로 제한
// 반면에 추상 팩토리는 다형성을 적극적으로 활용하여 다수의 하위 클래스를 생성하고 관리
// 추상화를 통해 그룹을 만들 수 있음
public class AbstractFactoryMain {

  public static void main(String[] args) {
    // 한국 공장
    final Factory korea = new KoreaFactory();

    final TireProduct koreaTire = korea.createTire();
    koreaTire.makeAssemble();

    final DoorProduct koreaDoor = korea.createDoor();
    koreaDoor.makeAssemble();

    // 미국 공장
    final Factory state = new StateFactory();

    final TireProduct stateTire = state.createTire();
    stateTire.makeAssemble();

    final DoorProduct stateDoor = state.createDoor();
    stateDoor.makeAssemble();
  }

}
