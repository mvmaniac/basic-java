package io.devfactory.designpattern.behavior.iterator;

// 집합체를 위한 인터페이스
// 컬력션에서 처리하는 메서드 규약을 정의
public interface Aggregate<T> {

  IteratorObject<T> iterator();

}
