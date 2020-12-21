package io.devfactory.designpattern.structure.adapter;

import io.devfactory.designpattern.structure.adapter.service.Math;
import lombok.extern.slf4j.Slf4j;

// 어댑터 패턴 (Adapter Pattern)
// 코드를 재사용하기 위해 구조를 변경하는 패턴
// 다른 말로 래퍼 패턴 (Wrapper Pattern) 이라고도 하며, 기존의 클래스를 새로운 클래스로 감싸는 기법
// 크게 2가지 방법으로 클래스 어댑터(상속)와 객체 어댑터(구성)가 있음
// 클래스 어댑터는 상속 특성을 이용하며, 사용하기 위해서는 다중상속이 필요한데 최신 언어에서 다중 상속을 지원하지
// 않으므로 다중상속을 이용한 클래스 어댑터를 표현하는 것은 어려움
// 객체 어댑터는 객체의 의존성을 이용해 문제를 해결 함
// 기존 타깃인 객체의 인터페이스에 영향을 받으며, 타깃의 인터페이스가 복잡할수록 많은 작업이 필요함
// 어댑터 패턴은 한 개의 Adapter 클래스를 이용하여 여러 개의 Adaptee 클래스를 연결함으로써 문제를 해결
// 해당 패턴을 적용한다고 해서 코드의 성능이 개선되는 것은 아니며 오히려 어댑터를 통해야 하므로 속도가 저하됨
// 오래된 레거시 코드나 라이브러리를 재사용할 때 유용함
// 서로 호환되지 않는 인터페이스를 가진 코드를 결합하여 응용 프로그램에서 동작할 수 있도록 도와줌
@SuppressWarnings("squid:S2440")
@Slf4j
public class AdapterMain {

  public static void main(String[] args) {
    // 어댑터를 이용하여 2배 게산
    final Objects objects = new Objects(new Math());

    log.debug("{}", objects.twiceOf(5));
    log.debug("{}", objects.halfOf(4));
  }

}
