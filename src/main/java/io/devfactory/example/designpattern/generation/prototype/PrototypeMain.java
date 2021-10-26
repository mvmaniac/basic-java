package io.devfactory.example.designpattern.generation.prototype;

import io.devfactory.example.designpattern.generation.prototype.service.Hello;
import lombok.extern.slf4j.Slf4j;

// 프로토타입 패턴 (Prototype Pattern)
// new 키워드를 사용하지 않고 객체를 복제해 생성하는 패턴
// 기존의 동일한 객체가 있다면 새롭게 생성하는 것보다 기존 객체를 복제하는것이 좋음
// 이미 생성된 객체를 복제할 경우 인스턴스화 과정이 생략되지 때문
// 객체를 복제하면 생성 로직에 소모되는 처리 시간과 자원을 절약 할 수 있음
@Slf4j
public class PrototypeMain {

  public static void main(String[] args) {
    // 객체를 생성
    Hello hello = new Hello("안녕하세요");
    log.debug("원본 내용: {}", hello.getMessage());

    // 객체를 복제
    Hello clone = hello.clone();
    clone.setMessage("Hello world");

    // 원복 객체와 복제 객체의 메시지를 출력
    log.debug("clone: {}", clone.getMessage());
    log.debug("hello: {}", hello.getMessage());
  }

}
