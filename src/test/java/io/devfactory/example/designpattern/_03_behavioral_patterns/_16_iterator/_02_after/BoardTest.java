package io.devfactory.example.designpattern._03_behavioral_patterns._16_iterator._02_after;

import io.devfactory.example.designpattern._03_behavioral_patterns._16_iterator._01_before.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

@Slf4j
class BoardTest {

  @DisplayName("변경 후 이터레이터 패턴 테스트")
  @Test
  void testIterator() {
    Board board = new Board();
    board.addPost("디자인 패턴 게임");
    board.addPost("선생님, 저랑 디자인 패턴 하나 학습하시겠습니까?");
    board.addPost("지금 이 자리에 계신 여러분들은 모두 디자인 패턴을 학습하고 계신 분들입니다.");

    // 들어간 순서대로 순회하기
    List<Post> posts = board.getPosts();
    Iterator<Post> iterator = posts.iterator();
    log.debug("{}", iterator.getClass());

    for (Post post : posts) {
      log.debug(post.getTitle());
    }

    // 가장 최신 글 먼저 순회하기
    Iterator<Post> recentPostIterator = board.getRecentPostIterator();
    while(recentPostIterator.hasNext()) {
      log.debug(recentPostIterator.next().getTitle());
    }
  }

}
