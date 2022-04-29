package io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier.before;

import io.devfactory.example.refactoring._06_mutable_data._19_separate_query_from_modifier.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Criminal {

  public String alertForMiscreant(List<Person> people) {
    for (Person p : people) {
      if (p.getName().equals("Don")) {
        setOffAlarms();
        return "Don";
      }

      if (p.getName().equals("John")) {
        setOffAlarms();
        return "John";
      }
    }

    return "";
  }

  private void setOffAlarms() {
    log.debug("set off alarm");
  }

}
