package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._02_after;

import java.util.ArrayDeque;
import java.util.Deque;

public class Button {

  private final Deque<Command> commands = new ArrayDeque<>();

  public void press(Command command) {
    command.execute();
    commands.push(command);
  }

  public void undo() {
    if (!commands.isEmpty()) {
      Command command = commands.pop();
      command.undo();
    }
  }

}
