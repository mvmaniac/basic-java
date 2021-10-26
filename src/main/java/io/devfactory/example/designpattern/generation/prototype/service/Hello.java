package io.devfactory.example.designpattern.generation.prototype.service;

import io.devfactory.global.error.ServiceRuntimeException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("squid:S2975")
@Slf4j
@Getter
@Setter
public class Hello implements Cloneable {

  private String message;

  public Hello(String message) {
    log.debug("Hello 를 생성합니다. => 생성자 로직 동작");
    this.message = message;
  }

  // clone 메서드를 오버라이드 하는 것 보다
  // 생성자를 통해서 직접 복제를 하는 것을 권장...
  // SuppressWarnings 를 제거하면 나옴...
  @Override
  public Hello clone() {
    try {
      return (Hello) super.clone();
    } catch (CloneNotSupportedException cse) {
      // 아무처리를 하지 않거나, RuntimeException 으로 감싸는 것이 사용하기 편하다.
      throw new ServiceRuntimeException();
    }
  }

}
