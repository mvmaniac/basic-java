package io.devfactory.example.designpattern.behavior.memento;

import io.devfactory.example.designpattern.behavior.memento.service.Hello;
import lombok.extern.slf4j.Slf4j;

// 메멘토 패턴 (Memento Pattern)
// 객체의 상태를 저장하여 이전 상태로 복구하는 패턴
// 객체를 복원하기 위해서는 완전한 객체의 내부 접근이 필요하고 
// 완전한 객체의 내부 접근을 허용하는 방법은 모두 public 속성으로 설정하면 됨
// 하지만 객체 내부의 모든 속성을 public 으로 해서 노출하면 캡슐화한 장점을 잃어버리게 됨
// 메멘토 패턴은 캡슐화 위반을 최소화하면서 객체 저장과 복원을 실행할 수 있도록 돕는 패턴
// 저장과 복원 작업을 처리하는 중간 매개체를 이용하면 보다 쉽계 상태 이력을 관리할 수 있는데 이러한 중간 매개체를 constrainSolver 라고 함
// 메멘토는 SolverState 로 객체의 상태를 관리, 객체의 상태를 저장하고, 저장된 상태의 객체를 복원
// 객체 저장과 복원을 위해 2가지 인터페이스를 사용
// - 원조본(originator)
// - 케어테이커(caretaker)
// 원조본은 광범위한 메멘토의 접근을 모두 허용하지만 케어테이커는 제한된 범위 안에서 허용
// 원조본은 실제 객체와 메멘토 사이의 중간 매개체 역할을 수행
// 케어테이커는 실행취소 메커니즘이고 제한적 범위의 인터페이스를 가지며, 다수의 메멘토를 보관하고 관리
// 원조본은 메멘토를 통해 자신의 객체 상태를 저장하며, 케어테이커는 원조본을 이용해 객체의 상태를 저장하는 동작을 결정
// 케어테이커는 메멘토를 보관하기만 할 뿐 자체 내용을 검사하거나 수정하지 않음
@SuppressWarnings({"squid:S1144","squid:S125"})
@Slf4j
public class MementoMain {

  public static void main(String[] args) {
    // 원조본만 사용
    // useOriginator();
    
    // 원조본, 케어테이커 사용
    useOriginatorAndCareTaker();
  }

  private static void useOriginatorAndCareTaker() {
    // 원조본, 케어테이커 객체를 생성
    final Originator originator = new Originator();
    final CareTaker careTaker = new CareTaker();

    // 첫 번째 인사말
    Hello hello = new Hello("상태1: 안녕하세요.");
    log.debug("{}", hello.getMessage());

    // 원조본에 객체를 설정, 저장함
    originator.setState(hello);
    careTaker.push(originator);

    // 상태 변경, 두 번째 인사말
    // 상태2를 설정하고, 메멘토를 통해 원조본을 케어테이커에 저장
    hello.setMessage("상태2: Hello nice meet you.");
    log.debug("{}", hello.getMessage());
    originator.setState(hello);
    careTaker.push(originator);

    // 상태 변경, 세 번째 인사말
    // 상태3를 설정하고, 메멘토를 통해 원조본을 케어테이커에 저장
    hello.setMessage("상태3: 곤니찌와");
    log.debug("{}", hello.getMessage());
    originator.setState(hello);
    careTaker.push(originator);

    // 메멘토를 통하여 상태3을 복원
    hello = careTaker.undo(originator);
    log.debug("{}", hello.getMessage());

    // 메멘토를 통하여 상태2을 복원
    hello = careTaker.undo(originator);
    log.debug("{}", hello.getMessage());

    // 메멘토를 통하여 상태1을 복원
    hello = careTaker.undo(originator);
    log.debug("{}", hello.getMessage());
  }

  private static void useOriginator() {
    // 원조본 객체를 생성
    final Originator originator = new Originator();

    // 첫 번째 인사말
    Hello hello = new Hello("상태1: 안녕하세요.");
    log.debug("{}", hello.getMessage());

    // 상태1을 설정하고, 원조본을 메메톤를 통해 저장
    originator.setState(hello);
    final Memento memento = originator.create(); // 저장

    // 상태 변경
    // 두 번째 인사말
    hello.setMessage("상태2: Hello nice meet you.");
    log.debug("{}", hello.getMessage());

    // 메멘토를 통해 상태1를 복원
    originator.restore(memento);
    hello = originator.getState(); // 복원
    log.debug("{}", hello.getMessage());
  }

}
