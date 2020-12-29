package io.devfactory.designpattern.behavior.command;

import java.util.HashMap;
import java.util.Map;

// 인보커
public class Invoker {

  private Map<String, Command> commandMap;

  public Invoker() {
    this.commandMap = new HashMap<>();
  }

  // 명령 객체를 저장
  public void set(String key, Command command) {
    commandMap.put(key, command);
  }

  // 명령 객체를 삭제
  public void remove(String key) {
    commandMap.remove(key);
  }

  // 명령 객체를 실행
  public void execute(String key) {
    if (commandMap.containsKey(key)) {
      commandMap.get(key).execute();
    }
  }

}
