package io.devfactory.example.refactoring._01_smell_mysterious_name._03_rename_field;

import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("DuplicatedCode")
@Slf4j
public class StudyDashboard {

  private final Set<StudyReview> studyReviews = new HashSet<>();

  /**
   * 스터디 리뷰 이슈에 작성되어 있는 리뷰어 목록과 리뷰를 읽어옵니다.
   *
   * @throws IOException
   */
  private void loadReviews() throws IOException {
    GitHub gitHub = GitHub.connect();
    GHRepository repository = gitHub.getRepository("whiteship/live-study");
    GHIssue issue = repository.getIssue(30);

    List<GHIssueComment> bringReviews = issue.getComments();
    for (GHIssueComment review : bringReviews) {
      studyReviews.add(new StudyReview(review.getUser().getName(), review.getBody()));
    }
  }

  public Set<StudyReview> getStudyReviews() {
    return studyReviews;
  }

  public static void main(String[] args) throws IOException {
    StudyDashboard studyDashboard = new StudyDashboard();
    studyDashboard.loadReviews();
    studyDashboard.getStudyReviews().forEach(r -> log.debug(r.toString()));
  }

}
