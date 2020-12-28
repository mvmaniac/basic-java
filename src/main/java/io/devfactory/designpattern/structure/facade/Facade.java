package io.devfactory.designpattern.structure.facade;

import io.devfactory.designpattern.structure.facade.service.Package1;
import io.devfactory.designpattern.structure.facade.service.Package2;
import io.devfactory.designpattern.structure.facade.service.Package3;

// 패키지 클래스에 대한 파사드 패턴
public class Facade {
  
  private Package1 package1;
  private Package2 package2;
  private Package3 package3;

  public Facade() {
    // 인스턴스를 생성
    package1 = new Package1();
    package2 = new Package2();
    package3 = new Package3();
  }

  // 패키지 동작 1,2,3을 한번에 수행해야 하는
  // 복잡한 동작을 파사드 메서드로 생성
  public void processAll() {
    package1.process();
    package2.process();
    package3.process();
  }

}
