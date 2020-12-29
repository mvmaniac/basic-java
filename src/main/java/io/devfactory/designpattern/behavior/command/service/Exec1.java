package io.devfactory.designpattern.behavior.command.service;

import io.devfactory.designpattern.behavior.command.Command;
import lombok.extern.slf4j.Slf4j;

// 명령 객체
@Slf4j
public class Exec1 implements Command {

  public Exec1() {
    log.debug("Exec1 객체를 생성합니다.");
  }

  // 인터페이스 적용
  // 실행 메서드 구현
  @Override
  public void execute() {
    log.debug("명령1을 싱행합니다.");
    // 추가 코드 작성
  }

}
