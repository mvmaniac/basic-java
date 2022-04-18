package io.devfactory.example.designpattern._03_behavioral_patterns._20_state._02_after;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OnlineCourse {

  private final List<Student> students = new ArrayList<>();
  private final List<String> reviews = new ArrayList<>();
  private State state = new Draft(this);

  public void addStudent(Student student) {
    this.state.addStudent(student);
  }

  public void addReview(String review, Student student) {
    this.state.addReview(review, student);
  }

  public void changeState(State state) {
    this.state = state;
  }

}
