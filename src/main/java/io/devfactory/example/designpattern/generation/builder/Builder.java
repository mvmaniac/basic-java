package io.devfactory.example.designpattern.generation.builder;

import io.devfactory.example.designpattern.generation.builder.service.Computer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Builder {

  protected Algorithm algorithm; // 알고리즘 객체를 저장

  public void changeAlgorithm(Algorithm algorithm) {
    log.debug("빌드 객체를 저장 합니다. {}", algorithm.getClass().getSimpleName());
    this.algorithm = algorithm;
  }

  public Computer getInstance() {
    return this.algorithm.getInstance();
  }

  public abstract Factory build();

}
