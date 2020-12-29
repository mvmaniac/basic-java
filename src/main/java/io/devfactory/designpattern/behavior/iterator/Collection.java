package io.devfactory.designpattern.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

// 컬렉션
// 순환하는 객체를 가진 단순한 묶음의 객체
public class Collection<T> implements Aggregate<T> {

  // 외부의 직접 수정을 방지
  private final List<T> objects;
  private int last;

  public Collection() {
    objects = new ArrayList<>();
    last = 0;
  }

  // 집합에서 하나의 객체를 반환
  public T getObj(int index) {
    return objects.get(index);
  }
  
  // 전체 객체의 개수를 반환
  public int getLast() {
    return last;
  }

  // 새로운 객체를 추가
  public void append(T object) {
    objects.add(object);
    last += 1;
  }

  // 인터페이스 구현
  @Override
  public IteratorObject<T> iterator() {
    // 이터레이터 객체를 생성
    return new IteratorObject<>(this);
  }

}
