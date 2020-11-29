package io.devfactory.designpattern.generation.singleton;

@SuppressWarnings({"squid:S1854","squid:S1481"})
public class SingletonMain {

  public static void main(String[] args) {
    Config config;
    config = Config.getInstance();
    config = Config.getInstance();
  }

}
