package io.devfactory.example.designpattern.behavior.strategy;

import io.devfactory.example.designpattern.behavior.strategy.service.Gun;
import io.devfactory.example.designpattern.behavior.strategy.service.Knife;

// 전략 패턴 (Strategy Pattern)
// 객체 내부에서 해결해야 하는 목적을 알고리즘 객체로 분리 적용하는 기법
public class StrategyMain {

  public static void main(String[] args) {
    // 전략 패턴 실행
    final Character character = new Character();
    character.attack();
    
    // 무기 교환
    character.changeWeapon(new Knife());
    character.attack();

    // 무기 교환
    character.changeWeapon(new Gun());
    character.attack();
  }

}
