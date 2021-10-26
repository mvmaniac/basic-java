package io.devfactory.example.modernjava.functional;

import java.util.function.DoubleUnaryOperator;

public class Currying {

  private Currying() {
  }

  // 섭씨를 화씨로 변환
  public static double converter(double x, double f, double b) {
    return x * f + b;
  }

  // 섭씨를 화씨로 변환
  // 커링 개념을 활용한 한 개의 인수를 갖는 변환 함수를 반환
  public static DoubleUnaryOperator curriedConverter(double f, double b) {
    return x -> x * f + b;
  }

}
