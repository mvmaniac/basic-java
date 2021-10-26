package io.devfactory.example.designpattern.generation.builder;

import io.devfactory.example.designpattern.generation.builder.service.Computer;
import lombok.extern.slf4j.Slf4j;

// 빌더 패턴 (Builder Pattern)
// 추상 팩토리 패턴을 확장하고, 복잡한 단게를 가진 복합 객체를 생성
// 빌더는 관계된 서브 객체의 단계별 생성 절차가 완료된 후에 복합 객체를 생성 및 반환
// 추상 팩토리리는 객체를 생성한 즉시 반환
@Slf4j
public class BuilderMain {

  public static void main(String[] args) {
    // 알고리즘을 생성
    final Algorithm algorithm = new ProductModel();

    // 빌더 객체
    final Factory factory = new Factory();
    factory.changeAlgorithm(algorithm);

    // 생성 요청
    // 빌드 생성된 객체를 전달 받음
    final Computer computer = factory.build().getInstance();

    log.debug("{}", computer);
  }

}
