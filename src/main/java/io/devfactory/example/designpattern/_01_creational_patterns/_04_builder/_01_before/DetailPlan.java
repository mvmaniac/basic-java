package io.devfactory.example.designpattern._01_creational_patterns._04_builder._01_before;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.StringJoiner;

@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor
@Getter
public class DetailPlan {

  private final int day;
  private final String plan;

  @Override
  public String toString() {
    return new StringJoiner(", ", DetailPlan.class.getSimpleName() + "[", "]")
        .add("day=" + day)
        .add("plan='" + plan + "'")
        .toString();
  }

}
