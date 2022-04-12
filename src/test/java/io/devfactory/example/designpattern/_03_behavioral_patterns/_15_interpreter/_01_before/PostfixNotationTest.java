package io.devfactory.example.designpattern._03_behavioral_patterns._15_interpreter._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class PostfixNotationTest {

  @DisplayName("변경 전 인터프리터 패턴")
  @Test
  void testInterpreter() {
    PostfixNotation postfixNotation = new PostfixNotation("123+-");
    postfixNotation.calculate();
  }

}
