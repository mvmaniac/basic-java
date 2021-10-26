package io.devfactory.example.designpattern.behavior.chain;

import java.util.Objects;

public abstract class Chain {

  protected Chain next;

  public void setNext(Chain next) {
    this.next = next;
  }

  public abstract String execute(String event);

  // 이 메서드는 내가 임의로 추가함...
  public boolean canExecute() {
    return Objects.nonNull(next);
  }

}
