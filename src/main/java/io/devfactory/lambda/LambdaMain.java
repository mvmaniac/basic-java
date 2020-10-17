package io.devfactory.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaMain {

  private LambdaMain() {
  }

  public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
    final List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if (color.equals(apple.getColor())) {
        result.add(apple);
      }
    }

    return result;
  }

  public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
    final List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if (apple.getWeight() >= weight) {
        result.add(apple);
      }
    }

    return result;
  }

  // 람다 표현식 사용
  public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
    final List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }

    return result;
  }

  // 리스트 형식으로 추상화
  public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
    final List<T> result = new ArrayList<>();

    for (T t : inventory) {
      if (p.test(t)) {
        result.add(t);
      }
    }

    return result;
  }

}
