package io.devfactory.example.designpattern.generation.builder;

import io.devfactory.example.designpattern.generation.builder.service.Computer;

// 알고리즘의 공통된 동작을 위하여 추상 클래스를 선언
// 각 알고리즘으로 재정의되는 추상 메서드를 선언
public abstract class Algorithm {

  // 빌더 객체를 저장함
  protected Computer computer;

  public Computer getInstance() {
    return this.computer;
  }

  public abstract void assembleCpu(String cpu);

  public abstract void assembleMemory(int[] memory);

  public abstract void assembleStorage(int[] storage);

}
