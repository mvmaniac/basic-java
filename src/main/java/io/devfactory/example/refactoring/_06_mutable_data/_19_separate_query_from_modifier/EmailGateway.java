package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailGateway {

  public void send(String bill) {
    log.debug(bill);
  }

}
