package io.devfactory.example.designpattern._02_structural_patterns._07_bridge._01_before;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings({"NonAsciiCharacters", "squid:S101"})
@Slf4j
public class PoolParty아리 implements Champion {

  @Override
  public void move() {
    log.debug("PoolParty move");
  }

  @Override
  public void skillQ() {
    log.debug("PoolParty Q");
  }

  @Override
  public void skillW() {
    log.debug("PoolParty W");
  }

  @Override
  public void skillE() {
    log.debug("PoolParty E");
  }

  @Override
  public void skillR() {
    log.debug("PoolParty R");
  }

  @Override
  public String getName() {
    return null;
  }

}
