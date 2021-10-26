package io.devfactory.example.designpattern.generation.abstractfactory;

import io.devfactory.example.designpattern.generation.abstractfactory.service.DoorProduct;
import io.devfactory.example.designpattern.generation.abstractfactory.service.TireProduct;

public abstract class Factory {

  public abstract TireProduct createTire();
  public abstract DoorProduct createDoor();

}
