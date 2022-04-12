package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._02_after;

import io.devfactory.example.designpattern._03_behavioral_patterns._14_command._01_before.Game;
import io.devfactory.example.designpattern._03_behavioral_patterns._14_command._01_before.Light;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ButtonTest {

  @DisplayName("변경 후 커맨트 패턴 테스트")
  @Test
  void testCommand() {
    Button button = new Button();
    button.press(new GameStartCommand(new Game()));
    button.press(new LightOnCommand(new Light()));
    button.undo();
    button.undo();

    MyApp myApp = new MyApp(new GameStartCommand(new Game()));
    myApp.press();
  }

}
