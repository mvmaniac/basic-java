package io.devfactory.example.designpattern.structure.decorator;

import io.devfactory.example.designpattern.structure.decorator.service.Component;
import lombok.extern.slf4j.Slf4j;

// ConcreateDecorator
@Slf4j
public class i7 extends Decorator {

  private final Component base; // 내부 잠조자

  public i7(Component concreate) {
    log.debug("i7 클래스가 생성이 되었습니다.");
    this.base = concreate;
  }

  @Override
  public String product() {
    return this.base.product() + ", i7";
  }

  @Override
  public int price() {
    return this.base.price() + 475_000;
  }

}
