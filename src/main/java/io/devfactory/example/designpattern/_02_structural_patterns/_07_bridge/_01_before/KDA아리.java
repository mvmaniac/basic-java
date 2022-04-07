package io.devfactory.example.designpattern._02_structural_patterns._07_bridge._01_before;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings({"NonAsciiCharacters", "squid:S101"})
@Slf4j
public class KDA아리 implements Champion {

  @Override
  public void move() {
    log.debug("KDA 아리 move");
  }

  @Override
  public void skillQ() {
    log.debug("KDA 아리 Q");
  }

  @Override
  public void skillW() {
    log.debug("KDA 아리 W");
  }

  @Override
  public void skillE() {
    log.debug("KDA 아리 E");
  }

  @Override
  public void skillR() {
    log.debug("KDA 아리 R");
  }

  @Override
  public String getName() {
    return null;
  }

}
