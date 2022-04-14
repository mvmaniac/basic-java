package io.devfactory.example.designpattern._03_behavioral_patterns._16_iterator._01_before;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Post {

  private String title;
  private LocalDateTime createdDateTime;

  public Post(String title) {
    this.title = title;
    this.createdDateTime = LocalDateTime.now();
  }

}
