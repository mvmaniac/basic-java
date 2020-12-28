package io.devfactory.designpattern.structure.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Factory {

  private final Map<String, Flyweight> pool;

  public Factory() {
    this.pool = new HashMap<>();
  }

  public Flyweight getCode(String key) {
    if (Objects.isNull(pool.get(key))) {
      Flyweight sharedObject = getSharedObject("Morse" + key.toUpperCase());
      this.pool.put(key, sharedObject);
    }

    return this.pool.get(key);
  }

  private Flyweight getSharedObject(String className) {
    try {
      final Class<?> clazz = Class.forName("io.devfactory.designpattern.structure.flyweight.service." + className);
      return (Flyweight) clazz.getDeclaredConstructor().newInstance();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

}
