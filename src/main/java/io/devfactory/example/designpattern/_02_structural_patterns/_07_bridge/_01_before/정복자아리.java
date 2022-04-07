package io.devfactory.example.designpattern._02_structural_patterns._07_bridge._01_before;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings({"NonAsciiCharacters", "squid:S101"})
@Slf4j
public class 정복자아리 implements Champion {

  @Override
  public void move() {
    log.debug("정복자 아리 move");
  }

  @Override
  public void skillQ() {
    log.debug("정복자 아리 Q");
  }

  @Override
  public void skillW() {
    log.debug("정복자 아리 W");
  }

  @Override
  public void skillE() {
    log.debug("정복자 아리 E");
  }

  @Override
  public void skillR() {
    log.debug("정복자 아리 R");
  }

  @Override
  public String getName() {
    return null;
  }

}
