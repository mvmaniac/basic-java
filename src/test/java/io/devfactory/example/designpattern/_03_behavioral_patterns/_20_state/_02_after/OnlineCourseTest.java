package io.devfactory.example.designpattern._03_behavioral_patterns._20_state._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class OnlineCourseTest {
  
  @DisplayName("변경 후 상태 패턴 테스트")
  @Test
  void testState() {
    OnlineCourse onlineCourse = new OnlineCourse();
    Student student = new Student("whiteship");
    Student keesun = new Student("keesun");
    keesun.addPrivate(onlineCourse);

    onlineCourse.addStudent(student);

    onlineCourse.changeState(new Private(onlineCourse));

    onlineCourse.addReview("hello", student);

    onlineCourse.addStudent(keesun);

    log.debug("state: {}", onlineCourse.getState());
    log.debug("students: {}", onlineCourse.getStudents());
    log.debug("reviews: {}", onlineCourse.getReviews());
  }

}
