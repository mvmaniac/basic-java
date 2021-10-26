package io.devfactory.example.designpattern.generation.builder.service;

import lombok.Getter;
import lombok.Setter;

// 기본 객체
@Getter
@Setter
public class Storage {

  private int size; // 저장장치 크기

  public Storage(int size) {
    this.size = size;
  }

}
