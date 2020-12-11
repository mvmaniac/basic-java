package io.devfactory.designpattern.generation.abstractfactory;

import io.devfactory.designpattern.generation.abstractfactory.service.DoorProduct;
import io.devfactory.designpattern.generation.abstractfactory.service.TireProduct;

public abstract class Factory {

  public abstract TireProduct createTire();
  public abstract DoorProduct createDoor();

}
