package io.devfactory.example.designpattern._03_behavioral_patterns._15_interpreter._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Slf4j
class PostfixExpressionTest {

  @DisplayName("변경 전 인터프리터 패턴")
  @Test
  void testInterpreter() {
    PostfixExpression expression = PostfixParser.parse("xyz+-a+");
    int result = expression.interpret(Map.of('x', 1, 'y', 2, 'z', 3, 'a', 4));
    log.debug("{}", result);
  }

}
