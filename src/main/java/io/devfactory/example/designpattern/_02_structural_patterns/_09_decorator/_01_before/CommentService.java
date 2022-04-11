package io.devfactory.example.designpattern._02_structural_patterns._09_decorator._01_before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommentService {

  public void addComment(String comment) {
    log.debug(comment);
  }

}
