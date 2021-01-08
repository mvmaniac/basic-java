package io.devfactory.designpattern.behavior.command.service;

import io.devfactory.designpattern.behavior.command.Command;
import lombok.extern.slf4j.Slf4j;

// 명령 객체
@Slf4j
public class Exec2 implements Command {

  private final Concrete receiver;

  public Exec2(Concrete receiver) {
    log.debug("Exec2 객체를 생성합니다.");

    // 실제 객체 의존성 주입
    this.receiver = receiver;
  }

  // 인터페이스 적용
  // 실제 메서드 구현
  @Override
  public void execute() {
    log.debug("명령2를 실행합니다.");
    
    // 여러 개의 리시버 동작을 처리 할 수 있음
    // 실제 객체의 명령을 수행
    receiver.action1();
    receiver.action2();
    
    // 추가 코드 작성
  }

}
