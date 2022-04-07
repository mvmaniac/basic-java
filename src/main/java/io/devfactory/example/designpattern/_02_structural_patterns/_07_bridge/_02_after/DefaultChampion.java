package io.devfactory.example.designpattern._02_structural_patterns._07_bridge._02_after;

import io.devfactory.example.designpattern._02_structural_patterns._07_bridge._01_before.Champion;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultChampion implements Champion {

  private final Skin skin;
  private final String name;

  public DefaultChampion(Skin skin, String name) {
    this.skin = skin;
    this.name = name;
  }

  @Override
  public void move() {
    log.debug("{} {} move\n", skin.getName(), this.name);
  }

  @Override
  public void skillQ() {
    log.debug("{} {} Q\n", skin.getName(), this.name);
  }

  @Override
  public void skillW() {
    log.debug("{} {} W\n", skin.getName(), this.name);
  }

  @Override
  public void skillE() {
    log.debug("{} {} E\n", skin.getName(), this.name);
  }

  @Override
  public void skillR() {
    log.debug("{} {} R\n", skin.getName(), this.name);
  }

  @Override
  public String getName() {
    return null;
  }

}
