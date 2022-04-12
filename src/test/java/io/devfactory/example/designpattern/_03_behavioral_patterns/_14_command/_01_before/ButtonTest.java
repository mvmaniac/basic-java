package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ButtonTest {

  @DisplayName("변경 전 커맨트 패턴 테스트")
  @Test
  void testCommand() {
    Button button = new Button(new Light());
    button.press();
    button.press();
    button.press();
    button.press();
  }

}
