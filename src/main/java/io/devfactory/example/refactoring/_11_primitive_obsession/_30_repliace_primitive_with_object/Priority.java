package io.devfactory.example.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class Priority {

  private static final List<String> LEGAL_VALUES = List.of("low", "normal", "high", "rush");

  private final String value;

  public Priority(String value) {
    if (!LEGAL_VALUES.contains(value)) {
      throw new IllegalArgumentException("illegal value for priority" + value);
    }
    this.value = value;
  }

  public boolean higherThan(Priority other) {
    return this.index() > other.index();
  }

  @Override
  public String toString() {
    return this.value;
  }

  private int index() {
    return LEGAL_VALUES.indexOf(this.value);
  }

}
