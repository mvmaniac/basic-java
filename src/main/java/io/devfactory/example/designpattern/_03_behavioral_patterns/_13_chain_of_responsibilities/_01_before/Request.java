package io.devfactory.example.designpattern._03_behavioral_patterns._13_chain_of_responsibilities._01_before;

import lombok.Getter;

@SuppressWarnings("ClassCanBeRecord")
@Getter
public class Request {

  private final String body;

  public Request(String body) {
    this.body = body;
  }

}
