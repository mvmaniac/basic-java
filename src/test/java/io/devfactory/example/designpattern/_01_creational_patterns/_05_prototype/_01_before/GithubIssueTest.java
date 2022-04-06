package io.devfactory.example.designpattern._01_creational_patterns._05_prototype._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class GithubIssueTest {

  @DisplayName("변경 전 프로토타입 패턴 테스트")
  @Test
  void beforePrototype() {
    GithubRepository repository = new GithubRepository();
    repository.setUser("whiteship");
    repository.setName("live-study");

    GithubIssue githubIssue = new GithubIssue(repository);
    githubIssue.setId(1);
    githubIssue.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

    log.debug("{}", githubIssue.getUrl());
  }

}
