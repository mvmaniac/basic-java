package io.devfactory.example.designpattern._03_behavioral_patterns._13_chain_of_responsibilities._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestHandler {

  public void handler(Request request) {
    log.debug(request.getBody());
  }

}
