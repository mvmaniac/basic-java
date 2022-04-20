package io.devfactory.example.refactoring._02_duplicated_code._05_slide_statements;

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
    GHIssue issue = getGhIssue(eventId);
    Set<String> participants = getUserNames(issue);
    print(participants);
  }

  private void print(Set<String> participants) {
    participants.forEach(log::debug);
  }

  private Set<String> getUserNames(GHIssue issue) throws IOException {
    Set<String> usernames = new HashSet<>();
    issue.getComments().forEach(c -> usernames.add(this.obtainUsername(c)));
    return usernames;
  }

  private GHIssue getGhIssue(int eventId) throws IOException {
    GitHub gitHub = GitHub.connect();
    GHRepository repository = gitHub.getRepository("whiteship/live-study");
    return repository.getIssue(eventId);
  }

  private void printReviewers() throws IOException {
    GHIssue issue = getGhIssue(30);
    Set<String> reviewers = getUserNames(issue);
    print(reviewers);
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
