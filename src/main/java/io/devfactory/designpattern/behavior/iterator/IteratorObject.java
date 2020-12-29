package io.devfactory.designpattern.behavior.iterator;

// 집합체의 이터레이터
// 반복 객체는 컬렉션에 저장된 객체를 순환하도록 객체를 반환하는 역할
public class IteratorObject<T> implements PloyIterator<T> {

  private final Collection<T> aggregate;
  private int index;

  public IteratorObject(Collection<T> aggregate) {
    this.aggregate = aggregate;
    this.index = 0;
  }

  @Override
  public boolean isNext() {
    return index < this.aggregate.getLast();
  }

  @Override
  public T next() {
    T object = this.aggregate.getObj(index);
    index += 1;
    return object;
  }

}
