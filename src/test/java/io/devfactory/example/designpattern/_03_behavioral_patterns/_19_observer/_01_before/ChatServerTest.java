package io.devfactory.example.designpattern._03_behavioral_patterns._19_observer._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ChatServerTest {
  
  @DisplayName("변경 전 옵저버 패턴 테스트")
  @Test
  void testObserver() {
    ChatServer chatServer = new ChatServer();

    User user1 = new User(chatServer);
    user1.sendMessage("디자인패턴", "이번엔 옵저버 패턴입니다.");
    user1.sendMessage("롤드컵2021", "LCK 화이팅!");

    User user2 = new User(chatServer);
    log.debug("{}", user2.getMessage("디자인패턴"));

    user1.sendMessage("디자인패턴", "예제 코드 보는 중..");
    log.debug("{}", user2.getMessage("디자인패턴"));
  }

}
