package io.devfactory.example.designpattern.structure.adapter;

import io.devfactory.example.designpattern.structure.adapter.service.Math;
import lombok.extern.slf4j.Slf4j;

// Math 클래스의 실숫값으로 전달하던 인자값을 정수로 변경하는 경우
// 어댑터 패턴으로 새롭게 구현된 코드
@Slf4j
public class Objects implements Adapter {

  private Math math;

  public Objects(Math math) {
    // 기존 클래스의 객체를 생성
    this.math = math;
  }

  @Override
  public int twiceOf(int num) {
    log.debug("정수 2배 적용 합니다.");
    
    // 캐스팅을 통해 실수로 변환하여 전달
    double result = this.math.towTime(num);
    
    // 캐스팅을 통해 정수로 변환하여 반환
    return (int) result;
  }

  @Override
  public int halfOf(int num) {
    log.debug("정수 1/2배 적용 합니다.");

    // 캐스팅을 통해 실수로 변환하여 전달
    double result = this.math.halfTime(num);

    // 캐스팅을 통해 정수로 변환하여 반환
    return (int) result;
  }

}
