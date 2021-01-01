package io.devfactory.designpattern.behavior.mediator.service;

import io.devfactory.designpattern.behavior.mediator.Mediator;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

// concreteMediator
@Slf4j
public class Server extends Mediator<User> {

  public Server() {
    log.debug("중재자 생성이 되었습니다.");
    this.colleagues = new ArrayList<>();
  }

  // 중재 기능
  @Override
  public void mediate(String data, String user) {
    log.debug("{} 로 부터 서버 메세지를 받았습니다.", user);

    // 모든 Colleague 에게 전달 받은 메세지를 통보함
    colleagues.forEach(c -> {
      log.debug("<< {}", c.userName());
      c.message(data);
    });
  }

}
