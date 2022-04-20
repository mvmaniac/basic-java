package io.devfactory.example.refactoring._02_duplicated_code._01_before;

import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"DuplicatedCode", "SameParameterValue"})
@Slf4j
public class StudyDashboard {

  private void printParticipants(int eventId) throws IOException {
    // Get github issue to check homework
    GitHub gitHub = GitHub.connect();
    GHRepository repository = gitHub.getRepository("whiteship/live-study");
    GHIssue issue = repository.getIssue(eventId);

    // Get participants
    Set<String> participants = new HashSet<>();
    issue.getComments().forEach(c -> participants.add(this.obtainUsername(c)));

    // Print participants
    participants.forEach(log::debug);
  }

  private void printReviewers() throws IOException {
    // Get github issue to check homework
    GitHub gitHub = GitHub.connect();
    GHRepository repository = gitHub.getRepository("whiteship/live-study");
    GHIssue issue = repository.getIssue(30);

    // Get reviewers
    Set<String> reviewers = new HashSet<>();
    issue.getComments().forEach(c -> reviewers.add(this.obtainUsername(c)));

    // Print reviewers
    reviewers.forEach(log::debug);
  }

  private String obtainUsername(GHIssueComment comment) {
    try {
      return comment.getUser().getName();
    } catch (IOException e) {
      return "";
    }
  }

  public static void main(String[] args) throws IOException {
    StudyDashboard studyDashboard = new StudyDashboard();
    studyDashboard.printReviewers();
    studyDashboard.printParticipants(15);
  }

}
