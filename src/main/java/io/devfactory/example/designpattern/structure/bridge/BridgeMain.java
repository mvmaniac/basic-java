package io.devfactory.example.designpattern.structure.bridge;

import io.devfactory.example.designpattern.structure.bridge.service.English;
import io.devfactory.example.designpattern.structure.bridge.service.Korean;
import lombok.extern.slf4j.Slf4j;

// 브리지 패턴 (Bridge Pattern)
// 겍체의 확장성을 향상하기 위한 패턴
// 객체에서 동작을 처리하는 구현부와 확장을 위한 추상부를 분리
// 다른 말로 핸들 패턴 (Handle Pattern) 또는 구현부 패턴 이라고도 함
// 브리지 패턴을 적용하려면 4개의 구성요소(Implementor, ConcreateImplementor, Abstract, refinedAbstract)가 필요함
// 동작하고자 하는 기능을 구현부와 추상화 형태로 분리하며, 새로운 기능을 확장으로 처리하지 않고 위임으로 처리
// 이렇게 분리된 기능과 구현을 브리지화 형태로 결합해 동작하는 패턴
// 어댑터 패턴이 완성된 코드를 통합하고 결합할 때 사용되는 패턴이라면, 
// 브리지 패턴은 처음 설계 단계에서 추상화 및 구현을 위해 확장을 고려한 패턴
@Slf4j
public class BridgeMain {

  public static void main(String[] args) {
    boolean isKor = false;
    Message message;

    // 선택한 언어에 따라 인사말이 변경
    if (isKor) {
      message = new Message(new Korean());
    } else {
      message = new Message(new English());
    }

    log.debug("{}", message.greeting());
  }

}
