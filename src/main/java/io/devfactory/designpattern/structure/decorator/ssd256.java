package io.devfactory.designpattern.structure.decorator;

import io.devfactory.designpattern.structure.decorator.service.Component;
import lombok.extern.slf4j.Slf4j;

// ConcreateDecorator
@Slf4j
public class ssd256 extends Decorator {

  private final Component base; // 내부 잠조자

  public ssd256(Component concreate) {
    log.debug("ssd256 클래스가 생성이 되었습니다.");
    this.base = concreate;
  }

  @Override
  public String product() {
    return this.base.product() + ", ssd256";
  }

  @Override
  public int price() {
    return this.base.price() + 110_000;
  }

}
