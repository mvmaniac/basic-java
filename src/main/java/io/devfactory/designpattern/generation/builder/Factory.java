package io.devfactory.designpattern.generation.builder;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

// 외부에서 알고리즘을 전달 받음
@Slf4j
public class Factory extends Builder {

  public Factory() {
    this(null);
  }

  // 알고리즘 의존성을 주입 받음
  public Factory(Algorithm algorithm) {
    log.debug("Factory 객체를 생성하였습니다.");

    if (Objects.nonNull(algorithm)) {
      this.algorithm = algorithm;
    }
  }

  // 단계별 빌더의 메서드를 호출 합니다.
  @Override
  public Factory build() {
    log.debug("빌드 합니다.");

    this.algorithm.assembleCpu("i7");
    this.algorithm.assembleMemory(new int[]{8, 8});
    this.algorithm.assembleStorage(new int[]{256, 512});

    return this;
  }

}
