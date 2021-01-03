package io.devfactory.designpattern.behavior.templatemethod.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Sandwich {

  // 공통된 기능은 하위 클래스에서 오러바리딩되지 않도록 방지하기 위해 final 키워드를 사용
  public final String make() {
    String food = "";

    // 1단계: 빵을 하나 준비함
    food += this.bread();

    // 2단계: 준비된 빵에 속재료를 올려 놓음
    food += " + ";
    food += this.jam();

    // 3단계: 속재료 위에 다시 빵 하나를 놓음
    food += " + ";
    food += this.bread();
    
    // 생성된 샌드위치를 반환
    return food;
  }

  protected abstract String bread();

  protected abstract String jam();

}
