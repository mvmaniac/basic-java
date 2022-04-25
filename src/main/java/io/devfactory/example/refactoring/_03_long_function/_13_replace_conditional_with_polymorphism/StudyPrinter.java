package io.devfactory.example.refactoring._03_long_function._13_replace_conditional_with_polymorphism;

import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings({"DuplicatedCode"})
@Slf4j
public abstract class StudyPrinter {

  protected final int totalNumberOfEvents;

  protected final List<Participant> participants;

  protected StudyPrinter(int totalNumberOfEvents, List<Participant> participants) {
    this.totalNumberOfEvents = totalNumberOfEvents;
    this.participants = participants;
    this.participants.sort(Comparator.comparing(Participant::username));
  }

  /**
   * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
   */
  protected String checkMark(Participant p) {
    StringBuilder line = new StringBuilder();
    for (int i = 1; i <= this.totalNumberOfEvents; i++) {
      if (p.homework().containsKey(i) && p.homework().get(i)) {
        line.append("|:white_check_mark:");
      } else {
        line.append("|:x:");
      }
    }
    return line.toString();
  }

  public abstract void execute() throws IOException;

}
