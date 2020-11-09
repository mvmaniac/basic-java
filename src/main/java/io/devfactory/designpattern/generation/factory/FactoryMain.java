package io.devfactory.designpattern.generation.factory;

import io.devfactory.designpattern.generation.factory.service.Hello;
import lombok.extern.slf4j.Slf4j;

import static io.devfactory.designpattern.generation.factory.service.greeting.Language.ENGLISH;
import static io.devfactory.designpattern.generation.factory.service.greeting.Language.KOREAN;

// 팩토리 패턴 (Factory Pattern)
// 장점
// 코드에서 생성과 관련된 모든 처리를 별도의 클래스 객체로 위임하며 사용 과 생성을 분리하는 과정에서 중복된 코드를 정리하는 효과도 있음.
// 유연성과 확장성이 개선되며 개발 과정에서 클래스 이름이 변경돼도 코드를 일일 이 수정하지 않고 팩토리 객체를 통해 손쉽게 변경할 수 있음.
// 팩토리 패턴은 어떤 객체를 생성할지 모르는 초기 단계 코드에 매우 유용 한데 일단 객체를 먼저 호출해서 사용한 후 쉽게 수정할 수 있기 때문.
//
// 단점
// 팩토리 패턴은 객체 생성을 위임하는 데 별도의 새로운 클래스가 필요함.
// 관리할 클래스 파일이 늘어난다는 것도 단점. 이 단점을 보완하기 위해 단순 팩토리를 사용할 수도 있음.
@Slf4j
public class FactoryMain {

  public static void main(String[] args) {
    final Hello hello = new Hello();

    log.debug("{}", hello.greeting(KOREAN));
    log.debug("{}", hello.greeting(ENGLISH));
  }

}
