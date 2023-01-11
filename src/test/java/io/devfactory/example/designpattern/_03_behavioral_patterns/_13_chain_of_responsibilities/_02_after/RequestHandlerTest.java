package io.devfactory.example.designpattern._03_behavioral_patterns._13_chain_of_responsibilities._02_after;

import io.devfactory.example.designpattern._03_behavioral_patterns._13_chain_of_responsibilities._01_before.Request;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class RequestHandlerTest {

  private final RequestHandler requestHandler;

  public RequestHandlerTest(RequestHandler requestHandler) {
    this.requestHandler = requestHandler;
  }

  @DisplayName("변경 후 책임 연쇄 패턴 테스트")
  @Test
  void testChainOfResponsibilities() {
    RequestHandler chain = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));
    RequestHandlerTest client = new RequestHandlerTest(chain); // client에서 사용한다고 가정
    client.doWork();
  }

  private void doWork() {
    Request request = new Request("이번 놀이는 뽑기입니다.");
    requestHandler.handle(request);
  }

}
