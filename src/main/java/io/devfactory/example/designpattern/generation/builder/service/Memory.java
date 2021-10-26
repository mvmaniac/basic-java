package io.devfactory.example.designpattern.generation.builder.service;

import lombok.Getter;
import lombok.Setter;

// 기본 객체
@Getter
@Setter
public class Memory {

  private int size; // 메모리 사이즈

  public Memory(int size) {
    this.size = size;
  }

}
