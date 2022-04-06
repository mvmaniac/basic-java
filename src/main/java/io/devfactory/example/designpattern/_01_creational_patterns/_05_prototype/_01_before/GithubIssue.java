package io.devfactory.example.designpattern._01_creational_patterns._05_prototype._01_before;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GithubIssue {

  private final GithubRepository repository;
  private int id;
  private String title;

  public GithubIssue(GithubRepository repository) {
    this.repository = repository;
  }

  public String getUrl() {
    return String.format("https://github.com/%s/%s/issues/%d",
        repository.getUser(),
        repository.getName(),
        this.getId());
  }

}
