package io.devfactory.example.designpattern.structure.proxy;

import io.devfactory.example.designpattern.structure.proxy.service.RealSubject;
import io.devfactory.example.designpattern.structure.proxy.service.Subject;

// 프록시 패턴 (Proxy Pattern)
// 객체 접근을 제어하기 위해 중간 단계에 대리자를 위치시키는 패턴
// 무슨 일을 직접 처리하지 않고 대리자를 내세워 처리를 위임
// 하나의 객체를 두 개로 나눠 재구성한다는 것으로 분리하는 이유는 직접적인 접근을 막고 대리할 객체를 구현하기 위해서임
// 프록시에 분리된 두 개의 객체는 서로 다른 객체가 아니며, 두 객체는 동일한 인터페이스 규격을 갖고 있음
// 프록시는 단지 객체의 접근과 동작을 제어하기 위한 중간 제어 구조가 추가된 객체일 뿐임
// 응용 범위 따라 다르게 불리는 파생 프록시들도 있음 (원격 프록시, 가상 프록시, 보호 프록시, 스마트 프록시)
// 프록시는 대리인을 의미하며, 실제 객체에 접근하지 않고 똑같이 동작하는 대리자를 생성
// 프록시는 대리자 객체를 통해 실제 객체를 가로챈 후 대리자 객체로 우외한 접근을 허용
// 프록시에서 위임은 프록시 객체와 실제 객체를 연결하는 고리로 의존성 주입을 통해 실제 객체와 프록시 객체를 연결
// 프록시 객체가 실제 객체로 행위를 위임하는 것을 봤을 때 프록시 객체는 복합 객체가 됨
public class ProxyMain {

  public static void main(String[] args) {
    final Subject realSubject = new RealSubject();
    final Proxy proxy = new Proxy(realSubject);

    proxy.action1();
    proxy.action2();
  }

}
