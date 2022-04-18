package io.devfactory.example.designpattern._03_behavioral_patterns._20_state._01_before;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Student {

  private final List<OnlineCourse> privateCourses = new ArrayList<>();
  private final String name;

  public Student(String name) {
    this.name = name;
  }

  public boolean isEnabledForPrivateClass(OnlineCourse onlineCourse) {
    return privateCourses.contains(onlineCourse);
  }

  public void addPrivateCourse(OnlineCourse onlineCourse) {
    this.privateCourses.add(onlineCourse);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
        .add("privateCourses=" + privateCourses)
        .add("name='" + name + "'")
        .toString();
  }

}
