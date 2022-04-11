package io.devfactory.example.designpattern._02_structural_patterns._09_decorator._02_after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultCommentService implements CommentService {

  @Override
  public void addComment(String comment) {
    log.debug(comment);
  }

}
