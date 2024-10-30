package io.devfactory.example.designpattern._02_structural_patterns._09_decorator._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("squid:S1186")
@Slf4j
class ClientTest {

  private static final boolean enabledSpamFilter = true;
  private static final boolean enabledTrimming = true;

  @DisplayName("변경 후 데코레이터 패턴 테스트")
  @Test
  void testDecorator() {
    CommentService commentService = new DefaultCommentService();

    if (enabledSpamFilter) {
      commentService = new SpamFilteringCommentDecorator(commentService);
    }

    if (enabledTrimming) {
      commentService = new TrimmingCommentDecorator(commentService);
    }

    Client client = new Client(commentService);
    client.writeComment("오징어게임");
    client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
    client.writeComment("http://whiteship.me");
  }

}
