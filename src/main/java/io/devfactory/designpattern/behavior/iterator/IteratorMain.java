package io.devfactory.designpattern.behavior.iterator;

import io.devfactory.designpattern.behavior.iterator.service.Fruit;
import lombok.extern.slf4j.Slf4j;

// 반복자 패턴 (Iterator Pattern)
// 내부 구조를 노출하지 않고 집합체를 통해 원소 객체에 순차적으로 접근 할 수 있는 방법을 제공
// 객체의 효율적인 집합 관리를 위해 별도의 집합체(Aggregate)를 갖고 있음
// 반족자는 객체를 순환하는 제어부를 캡슐화 함
// 반복되는 객체의 행위를 외부 객체로 분리하기 위해 반복자 패턴을 사용하며, 외부로 분리된 반복자를 통해 순환 처리를 위임
// 직접 배열로 객체를 저장하는 방법 대신 집합체를 이용하여 컬렉션을 생성
// 컬렉션을 통해 외부 반복자를 생성하고, 이 외부 반복자로 컬렉션에 저장된 객체들에 순차적으로 접근하여 순환
@Slf4j
public class IteratorMain {

  public static void main(String[] args) {
    // 집합 생성 및 요소 추가
    final Collection<Fruit> menu = new Collection<>();
    menu.append(new Fruit("Apple"));
    menu.append(new Fruit("Banana"));
    menu.append(new Fruit("Berry"));
    menu.append(new Fruit("Grape"));

    // 반복자 객체 호출
    final IteratorObject<Fruit> loop = menu.iterator();

    while (loop.isNext()) {
      Fruit fruit = loop.next();
      log.debug("{}", fruit.getName());
    }
  }

}
