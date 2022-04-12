package io.devfactory.example.designpattern._03_behavioral_patterns._13_chain_of_responsibilities._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class RequestHandlerTest {
  
  @DisplayName("변경 전 책임 연쇄 패턴 테스트")
  @Test
  void testChainOfResponsibilities() {
    Request request = new Request("무궁화 꽃이 피었습니다.");
    RequestHandler requestHandler = new LoggingRequestHandler();
    requestHandler.handler(request);
  }

}
