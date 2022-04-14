package io.devfactory.example.designpattern._03_behavioral_patterns._19_observer._01_before;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class User {

  private final ChatServer chatServer;

  public User(ChatServer chatServer) {
    this.chatServer = chatServer;
  }

  public void sendMessage(String subject, String message) {
    chatServer.add(subject, message);
  }

  public List<String> getMessage(String subject) {
    return chatServer.getMessage(subject);
  }

}