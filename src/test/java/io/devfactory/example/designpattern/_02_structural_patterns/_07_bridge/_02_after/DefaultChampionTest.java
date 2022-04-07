package io.devfactory.example.designpattern._02_structural_patterns._07_bridge._02_after;

import io.devfactory.example.designpattern._02_structural_patterns._07_bridge._01_before.Champion;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "squid:S101", "squid:S2699"})
@Slf4j
class DefaultChampionTest {

  @DisplayName("변경 후 브릿지 패턴 테스트")
  @Test
  void afterBridge() {
    Champion kda아리 = new 아리(new KDA());
    kda아리.skillQ();
    kda아리.skillW();

    Champion poolParty아리 = new 아리(new PoolParty());
    poolParty아리.skillR();
    poolParty아리.skillW();
  }

}
