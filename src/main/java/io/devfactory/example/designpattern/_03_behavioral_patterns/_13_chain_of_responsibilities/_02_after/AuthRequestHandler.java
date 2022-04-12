package io.devfactory.example.designpattern._03_behavioral_patterns._13_chain_of_responsibilities._02_after;

import io.devfactory.example.designpattern._03_behavioral_patterns._13_chain_of_responsibilities._01_before.Request;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthRequestHandler extends RequestHandler {

  public AuthRequestHandler(RequestHandler nextHandler) {
    super(nextHandler);
  }

  @Override
  public void handle(Request request) {
    log.debug("인증이 되었는가?");
    super.handle(request);
  }

}
