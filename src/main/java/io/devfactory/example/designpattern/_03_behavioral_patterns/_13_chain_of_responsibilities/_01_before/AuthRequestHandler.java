package io.devfactory.example.designpattern._03_behavioral_patterns._13_chain_of_responsibilities._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthRequestHandler extends RequestHandler {

  public void handler(Request request) {
    log.debug("인증이 되었나?");
    log.debug("이 핸들러를 사용할 수 있는 유저인가?");
    super.handler(request);
  }

}
