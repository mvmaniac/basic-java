package io.devfactory.example.designpattern.generation.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Config {

  private static Config instance = null;

  private Config() {
    log.debug("Config 가 생성이 되었습니다.");
  }

  public static Config getInstance() {
    if (Objects.isNull(instance)) {
      log.debug("Config 객체를 생성합니다.");
      instance = new Config();
    }

    log.debug("Config 객체를 반환합니다. {}", instance);
    return instance;
  }

}
