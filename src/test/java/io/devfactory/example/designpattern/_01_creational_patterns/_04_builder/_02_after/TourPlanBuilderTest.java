package io.devfactory.example.designpattern._01_creational_patterns._04_builder._02_after;

import io.devfactory.example.designpattern._01_creational_patterns._04_builder._01_before.TourPlan;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class TourPlanBuilderTest {

  @DisplayName("변경 후 빌더 패턴 테스트")
  @Test
  void afterBuilder() {
    TourDirector director = new TourDirector(new DefaultTourBuilder());

    TourPlan tourPlan = director.cancunTrip();
    log.debug("{}", tourPlan);

    tourPlan = director.longBeachTrip();
    log.debug("{}", tourPlan);
  }

}
