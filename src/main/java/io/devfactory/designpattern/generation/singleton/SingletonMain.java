package io.devfactory.designpattern.generation.singleton;

// 싱글턴 패턴 (Singleton Pattern)
@SuppressWarnings({"squid:S1854","squid:S1481"})
public class SingletonMain {

  public static void main(String[] args) {
    Config config;
    config = Config.getInstance();
    config = Config.getInstance();
  }

}
