package io.devfactory.example.designpattern._03_behavioral_patterns._20_state._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class OnlineCourseTest {

  @DisplayName("변경 전 상태 패턴 테스트")
  @Test
  void testState() {
    Student student = new Student("whiteship");
    OnlineCourse onlineCourse = new OnlineCourse();

    Student keesun = new Student("keesun");
    keesun.addPrivateCourse(onlineCourse);

    onlineCourse.addStudent(student);
    onlineCourse.changeState(OnlineCourse.State.PRIVATE);

    onlineCourse.addStudent(keesun);

    onlineCourse.addReview("hello", student);

    log.debug("state: {}", onlineCourse.getState());
    log.debug("students: {}", onlineCourse.getStudents());
    log.debug("reviews: {}", onlineCourse.getReviews());
  }

}
