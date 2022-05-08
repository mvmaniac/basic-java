package io.devfactory.example.refactoring._13_loop._33_replace_loop_with_pipeline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AuthorTest {

  @Test
  void twitterHandler() {
    Author keesun = new Author("ms", null);
    Author whiteship = new Author("naver", "whiteship");

    assertThat(Author.twitterHandles(List.of(keesun, whiteship), "naver")).isEqualTo(List.of("whiteship"));
  }

}
