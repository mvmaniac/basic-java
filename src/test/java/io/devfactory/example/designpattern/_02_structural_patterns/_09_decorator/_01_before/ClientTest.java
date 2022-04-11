package io.devfactory.example.designpattern._02_structural_patterns._09_decorator._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("squid:S2699")
@Slf4j
class ClientTest {

  @DisplayName("변경 전 데코레이터 패턴 테스트")
  @Test
  void testDecorator() {
    Client client = new Client(new SpamFilteringCommentService());
    client.writeComment("오징어게임");
    client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
    client.writeComment("http://whiteship.me");
  }

}
