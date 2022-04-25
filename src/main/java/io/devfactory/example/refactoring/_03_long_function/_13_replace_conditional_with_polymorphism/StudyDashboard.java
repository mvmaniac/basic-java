package io.devfactory.example.refactoring._03_long_function._13_replace_conditional_with_polymorphism;

import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("DuplicatedCode")
@Slf4j
public class StudyDashboard {

  private final int totalNumberOfEvents;
  private final List<Participant> participants;
  private final Participant[] firstParticipantsForEachEvent;

  public StudyDashboard(int totalNumberOfEvents) {
    this.totalNumberOfEvents = totalNumberOfEvents;
    this.participants = new CopyOnWriteArrayList<>();
    this.firstParticipantsForEachEvent = new Participant[this.totalNumberOfEvents];
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    StudyDashboard studyDashboard = new StudyDashboard(15);
    studyDashboard.print();
  }

  private void print() throws IOException, InterruptedException {
    checkGithubIssues(getGhRepository());
    new MarkdownPrinter(this.totalNumberOfEvents, this.participants).execute();
    printFirstParticipants();
  }

  private void checkGithubIssues(GHRepository ghRepository) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(8);
    CountDownLatch latch = new CountDownLatch(this.totalNumberOfEvents);

    for (int index = 1; index <= this.totalNumberOfEvents; index++) {
      int eventId = index;
      service.execute(() -> {
        try {
          GHIssue issue = ghRepository.getIssue(eventId);
          List<GHIssueComment> comments = issue.getComments();

          checkHomework(eventId, comments);

          this.firstParticipantsForEachEvent[eventId - 1] = findFirst(comments);

          latch.countDown();
        } catch (IOException e) {
          throw new IllegalArgumentException(e);
        }
      });
    }

    latch.await();
    service.shutdown();
  }

  private GHRepository getGhRepository() throws IOException {
    GitHub gitHub = GitHub.connect();
    return gitHub.getRepository("whiteship/live-study");
  }

  private void checkHomework(int eventId, List<GHIssueComment> comments) throws IOException {
    for (GHIssueComment comment : comments) {
      Participant participant = findParticipant(comment.getUser().getName(), this.participants);
      participant.setHomeworkDone(eventId);
    }
  }

  private Participant findFirst(List<GHIssueComment> comments) throws IOException {
    Date firstCreatedAt = null;
    Participant first = null;
    for (GHIssueComment comment : comments) {
      Participant participant = findParticipant(comment.getUser().getName(), this.participants);

      if (firstCreatedAt == null || comment.getCreatedAt().before(firstCreatedAt)) {
        firstCreatedAt = comment.getCreatedAt();
        first = participant;
      }
    }
    return first;
  }

  private Participant findParticipant(String username, List<Participant> participants) {
    return isNewParticipant(username, participants) ?
        createNewParticipant(username, participants) :
        findExistingParticipant(username, participants);
  }

  private boolean isNewParticipant(String username, List<Participant> participants) {
    return participants.stream().noneMatch(p -> p.username().equals(username));
  }

  private Participant createNewParticipant(String username, List<Participant> participants) {
    Participant participant;
    participant = new Participant(username);
    participants.add(participant);
    return participant;
  }

  private Participant findExistingParticipant(String username, List<Participant> participants) {
    Participant participant;
    participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
    return participant;
  }

  private void printFirstParticipants() {
    Arrays.stream(this.firstParticipantsForEachEvent).forEach(p -> log.debug(p.username()));
  }

}
