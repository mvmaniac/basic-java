package io.devfactory.example.refactoring._03_long_function._09_preserve_whole_object;

import java.util.HashMap;
import java.util.Map;

public record Participant(String username, Map<Integer, Boolean> homework) {

  public Participant(String username) {
    this(username, new HashMap<>());
  }

  public void setHomeworkDone(int index) {
    this.homework.put(index, true);
  }

  public double getRate(double total) {
    long count = this.homework.values().stream()
        .filter(v -> v)
        .count();
    return count * 100 / total;
  }

}