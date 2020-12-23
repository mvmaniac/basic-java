package io.devfactory.designpattern.structure.decorator;

import io.devfactory.designpattern.structure.decorator.service.Component;

// Decorator
public abstract class Decorator implements Component {

  public abstract String product();

  public abstract int price();

}
