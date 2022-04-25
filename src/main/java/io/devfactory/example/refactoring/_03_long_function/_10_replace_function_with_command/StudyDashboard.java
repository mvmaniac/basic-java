package io.devfactory.example.refactoring._03_long_function._10_replace_function_with_command;

import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings({"DuplicatedCode", "ClassCanBeRecord"})
@Slf4j
public class StudyDashboard {

  private final int totalNumberOfEvents;

  public StudyDashboard(int totalNumberOfEvents) {
    this.totalNumberOfEvents = totalNumberOfEvents;
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    StudyDashboard studyDashboard = new StudyDashboard(15);
    studyDashboard.print();
  }

  private void print() throws IOException, InterruptedException {
    GitHub gitHub = GitHub.connect();
    GHRepository repository = gitHub.getRepository("whiteship/live-study");
    List<Participant> participants = new CopyOnWriteArrayList<>();

    ExecutorService service = Executors.newFixedThreadPool(8);
    CountDownLatch latch = new CountDownLatch(this.totalNumberOfEvents);

    for (int index = 1; index <= this.totalNumberOfEvents; index++) {
      int eventId = index;
      service.execute(() -> {
        try {
          GHIssue issue = repository.getIssue(eventId);
          List<GHIssueComment> comments = issue.getComments();

          for (GHIssueComment comment : comments) {
            Participant participant = findParticipant(comment.getUser().getName(), participants);
            participant.setHomeworkDone(eventId);
          }

          latch.countDown();
        } catch (IOException e) {
          throw new IllegalArgumentException(e);
        }
      });
    }

    latch.await();
    service.shutdown();

    new StudyPrinter(this.totalNumberOfEvents, participants);
  }

  private Participant findParticipant(String username, List<Participant> participants) {
    Participant participant;
    if (participants.stream().noneMatch(p -> p.username().equals(username))) {
      participant = new Participant(username);
      participants.add(participant);
    } else {
      participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
    }
    return participant;
  }

}
