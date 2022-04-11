package io.devfactory.example.designpattern._02_structural_patterns._10_facade._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Slf4j
class ClientTest {

  @DisplayName("변경 전 퍼사드 패턴 테스트")
  @Test
  void testFacade() {
    String to = "keesun@whiteship.me";
    String from = "whiteship@whiteship.me";
    String host = "127.0.0.1";

    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", host);

    Session session = Session.getDefaultInstance(properties);

    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Test Mail from Java Program");
      message.setText("message");

      Transport.send(message);
      log.debug("{}", message);

    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

}
