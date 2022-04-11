package io.devfactory.example.designpattern._02_structural_patterns._10_facade._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ClientTest {

  @DisplayName("변경 후 퍼사드 패턴 테스트")
  @Test
  void testFacade() {
    EmailSettings emailSettings = new EmailSettings();
    emailSettings.setHost("127.0.0.1");

    EmailSender emailSender = new EmailSender(emailSettings);

    EmailMessage emailMessage = new EmailMessage();
    emailMessage.setFrom("keesun");
    emailMessage.setTo("whiteship");
    emailMessage.setCc("일남");
    emailMessage.setSubject("오징어게임");
    emailMessage.setText("밖은 더 지옥이더라고..");

    emailSender.sendEmail(emailMessage);

    log.debug("{}", emailMessage);
  }

}
