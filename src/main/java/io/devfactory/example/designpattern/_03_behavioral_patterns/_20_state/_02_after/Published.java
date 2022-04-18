package io.devfactory.example.designpattern._03_behavioral_patterns._20_state._02_after;

@SuppressWarnings("ClassCanBeRecord")
public class Published implements State {

  private final OnlineCourse onlineCourse;

  public Published(OnlineCourse onlineCourse) {
    this.onlineCourse = onlineCourse;
  }

  @Override
  public void addReview(String review, Student student) {
    this.onlineCourse.getReviews().add(review);
  }

  @Override
  public void addStudent(Student student) {
    this.onlineCourse.getStudents().add(student);
  }

}
