package io.devfactory.example.designpattern._02_structural_patterns._07_bridge._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "squid:S101", "squid:S2699"})
@Slf4j
class ChampionTest {

  @DisplayName("변경 전 브릿지 패턴 테스트")
  @Test
  void beforeBridge() {
    Champion kda아리 = new KDA아리();

    kda아리.skillQ();
    kda아리.skillR();
  }

}
