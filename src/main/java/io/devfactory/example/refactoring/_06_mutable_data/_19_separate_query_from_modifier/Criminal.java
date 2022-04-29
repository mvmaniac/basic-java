package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Criminal {

  public void alertForMiscreant(List<Person> people) {
    if (findMiscreant(people).isBlank()) {
      return;
    }
    setOffAlarms();
  }

  public String findMiscreant(List<Person> people) {
    for (Person p : people) {
      if (p.getName().equals("Don")) {
        return "Don";
      }

      if (p.getName().equals("John")) {
        return "John";
      }
    }

    return "";
  }

  private void setOffAlarms() {
    log.debug("set off alarm");
  }

}
