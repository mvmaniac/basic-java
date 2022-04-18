package io.devfactory.example.designpattern._03_behavioral_patterns._20_state._02_after;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class Student {

  private final Set<OnlineCourse> onlineCourses = new HashSet<>();
  private final String name;

  public Student(String name) {
    this.name = name;
  }

  public boolean isAvailable(OnlineCourse onlineCourse) {
    return onlineCourses.contains(onlineCourse);
  }

  public void addPrivate(OnlineCourse onlineCourse) {
    this.onlineCourses.add(onlineCourse);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
        .add("onlineCourses=" + onlineCourses)
        .add("name='" + name + "'")
        .toString();
  }

}
