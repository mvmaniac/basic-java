package io.devfactory.example.designpattern._03_behavioral_patterns._16_iterator._01_before;

import io.devfactory.global.util.CommonUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Board {

  List<Post> posts = new ArrayList<>();

  public void addPost(String content) {
    // 테스트를 위한 일정간격 sleep
    CommonUtils.delayMilli(500);
    this.posts.add(new Post(content));
  }

}
