package io.devfactory.example.designpattern._01_creational_patterns._04_builder._01_before;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TourPlan {

  private String title;
  private int nights;
  private int days;
  private LocalDate startDate;
  private String whereToStay;
  private List<DetailPlan> plans;

  @Override
  public String toString() {
    return new StringJoiner(", ", TourPlan.class.getSimpleName() + "[", "]")
        .add("title='" + title + "'")
        .add("nights=" + nights)
        .add("days=" + days)
        .add("startDate=" + startDate)
        .add("whereToStay='" + whereToStay + "'")
        .add("plans=" + plans)
        .toString();
  }

  public void addPlan(int day, String plan) {
    this.plans.add(new DetailPlan(day, plan));
  }

}
