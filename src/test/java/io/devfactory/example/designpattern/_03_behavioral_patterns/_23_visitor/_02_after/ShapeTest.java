package io.devfactory.example.designpattern._03_behavioral_patterns._23_visitor._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("squid:S1186")
@Slf4j
class ShapeTest {

  @DisplayName("변경 후 비지터 패턴 테스트")
  @Test
  void testVisitor() {
    Shape rectangle = new Rectangle();
    Device device = new Pad();
    rectangle.accept(device);
  }

}
