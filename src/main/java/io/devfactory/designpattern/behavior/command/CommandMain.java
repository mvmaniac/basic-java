package io.devfactory.designpattern.behavior.command;

import io.devfactory.designpattern.behavior.command.service.Concrete;
import io.devfactory.designpattern.behavior.command.service.Exec1;
import io.devfactory.designpattern.behavior.command.service.Exec2;
import lombok.extern.slf4j.Slf4j;

// 명령 패턴 (Command Pattern)
// 핻동의 호출을 객체로 캡슐화하여 실행하는 패턴
// 유사한 동작을 하나의 객체로 묶어 실행하는 행위 패턴
// 실젝 작업을 수행하는 객체와 이를 실행하는 객체로 분리하여 설계
// 4가자의 구성요소를 가짐
// 인터페이스: 동일한 명령 구조와 호출을 위해 인테퍼이스를 정의
// 명령: 실행되는 실제 객체를 구현, 일급 객체로 분류 되며 명령에 따라 별개의 독립된 객체로 작성
// 리시버: 처리해야 하는 명령을 하나의 객체로 캡슐화, 외부로부터 객체를 위임 받아 대신 호출
// 인보커: 다수의 명령 객체를 관리, 생성된 명령 객체를 저장하고 관리하는 역할
// 명령 객체에 꼭 1개의 실행 메서드만 만들어서 사용할 필요는 없음
// 다수의 메서드를 인터페이스 형태로 선언해 다양한 실행 동작을 지정 할 수 있음
@Slf4j
public class CommandMain {

  public static void main(String[] args) {
    // 명령 객체를 생헝
    final Exec1 exec1 = new Exec1();

    // 객체를 실행
    exec1.execute();

    printLine();

    final Concrete concrete = new Concrete();
    
    // 명령 객체를 생성 (리시버 연결)
    final Exec2 exec2 = new Exec2(concrete);
    
    // 객체를 실행
    exec2.execute();

    printLine();

    // 인보커
    final Invoker invoker = new Invoker();
    invoker.set("cmd1", exec1);
    invoker.set("cmd2", exec2);
    
    // 객체를 실행
    invoker.execute("cmd1");
    invoker.execute("cmd2");
  }

  private static void printLine() {
    log.debug("");
    log.debug("============================");
    log.debug("");
  }

}
