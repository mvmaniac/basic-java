package io.devfactory.designpattern.structure.facade;

// 파사드 패턴 (Facade Pattern)
// 관심사를 분리하는 패턴으로 시스템 결합과 사용이 용이하도록 관심사를 분리함
// 해당 패턴은 메인 시스템과 서브 시스템 중간에 위치하는데, 새로운 인터페이스 계층을 추가하여 시스템 간 의존성을 해결함
// 인터페이스 계층은 메인 시스템과 서브 시스템의 연결 관계를 대신 처리
// 각각의 모듈 객체에 접근해서 호출하지 않고 파사드의 인터페이스 계층을 통해 간접적으로 접근
// 단방향이며 서브 시스템의 접근만 허용함
// 간단하며 일상적으로 많이 사용되는 패턴으로 수많은 API 서비스와 라이브러리, 패키지를 사용하는데 이들이 파사드 패턴을 응용하고 있다고 할 수 있음
public class FacadeMain {

  public static void main(String[] args) {
    // 파사드
    final Facade facade = new Facade();
    facade.processAll();
  }

}
