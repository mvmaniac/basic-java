package io.devfactory.designpattern.behavior.observer;

import io.devfactory.designpattern.behavior.observer.service.Members;
import io.devfactory.designpattern.behavior.observer.service.UserA;
import io.devfactory.designpattern.behavior.observer.service.UserB;
import lombok.extern.slf4j.Slf4j;

// 감시자 패턴 (Observer Pattern)
// 직접 상태값을 관찰하는 것이 아니라 수동적으로 상태값을 전달 받아 처리하는 패턴
// 크게 4개의 클래스로 구성됨
// 주체(subject)
// 실제 주체(concreteSubject)
// 감시자(observer)
// 실제 객체(concrateObserver)
// 그리고 4개의 클래스는 다시 2개의 그룹으로 구분
// 통보를 위한 주체-실제 주체 클래스
// 처리를 위한 감시자-실제 객체 클래스
// 주체-실제 주체는 객체의 등록, 삭제, 통보를 담당하는 클래스로 주체 클래스는 실제 처리하는 객체를 관리하고
// 관리를 담당하는 주체는 1개 이상의 감시자 객체를 갖고 있음
// 감시자-실제 객체는 통보를 수신 받아 처리하는 객체로 통보를 받으러면 주체 클래스에 수신 받는 객체를 등록해야 함
// 메인 구성 요소인 주체는 처리해야 하는 복수의 서브 객체(Observer)를 갖고 있음
// 주체-감시자가 하나의 커단란 객체 덩어리고, 이러한 객체 덩어리를 복합 구조 객체라고 함
// 감시자 객체는 감시자 인터페이스를 상혹하고 이를 구체화함
// 통보는 크게 수동적 통보와 능동적 통보로 구분
// 수동적 통보는 상태 변화가 감지되면 주체는 등록된 감시자에게 변경을 통보, 이때 주체는 감시지가 가진 공통된 메서를 호출
// 메시지를 수동적으로 수신한다는 측면에서 브로드캐스팅 통보와도 유사
// 능동적 통보는 감시가 객체가 메시지 수신만 받는 것은 아니며, 떄로는 자신의 변화를 주체에게 능동적으로 통보
// 주체는 하위 감시자 객체가 통보한 상태를 다른 감시자 객체에 통보 할 수 있음
// 상태 변화를 통보하는 측면에서 봤을 때 중재자 패턴과 유사하지만
// 감시자 패턴은 상태만 통보하면, 중재는 역할 조정을 목적으로 통보
@Slf4j
public class ObserverMain {

  public static void main(String[] args) {
    log.debug("감시자 패턴을 실행 합니다.");

    final Members members = new Members();

    // 감시자를 등록
    final UserA userA = new UserA("Jin");
    members.addObserver(userA);

    final UserB userB = new UserB("Eric");
    members.addObserver(userB);

    // 모든 감시자에게 통지를 전송
    members.notifyObserver();
    
    // 감시자 삭제
    members.deleteObserver(userA);

    // 모든 감시자에게 통지를 전송
    members.notifyObserver();
  }

}
