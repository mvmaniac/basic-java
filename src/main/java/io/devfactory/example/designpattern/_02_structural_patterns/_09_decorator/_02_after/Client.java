package io.devfactory.example.designpattern._02_structural_patterns._09_decorator._02_after;

@SuppressWarnings("ClassCanBeRecord")
public class Client {

  private final CommentService commentService;

  public Client(CommentService commentService) {
    this.commentService = commentService;
  }

  public void writeComment(String comment) {
    commentService.addComment(comment);
  }

}