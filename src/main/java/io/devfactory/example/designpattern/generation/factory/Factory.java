package io.devfactory.example.designpattern.generation.factory;

import io.devfactory.example.designpattern.generation.factory.service.greeting.English;
import io.devfactory.example.designpattern.generation.factory.service.greeting.Greeting;
import io.devfactory.example.designpattern.generation.factory.service.greeting.Korean;
import io.devfactory.example.designpattern.generation.factory.service.greeting.Language;
import io.devfactory.global.error.ServiceRuntimeException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

// 팩토리 클래스
@SuppressWarnings("squid:S1301")
@Slf4j
@UtilityClass
public class Factory {

  public static Greeting getInstance(Language language) {
    log.debug("객체를 생성하여 반환");

    switch (language) {
      case KOREAN -> new Korean();
      case ENGLISH -> new English();
    }

    throw new ServiceRuntimeException();
  }

}
