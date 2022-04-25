package io.devfactory.example.refactoring._03_long_function._13_replace_conditional_with_polymorphism;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class ConsolePrinter extends StudyPrinter {

  public ConsolePrinter(int totalNumberOfEvents, List<Participant> participants) {
    super(totalNumberOfEvents, participants);
  }

  @Override
  public void execute() throws IOException {
    this.participants.forEach(p -> log.debug("{} {}:{}", p.username(), checkMark(p), p.getRate(this.totalNumberOfEvents)));
  }

}
