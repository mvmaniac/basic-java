package io.devfactory.example.designpattern._02_structural_patterns._11_flyweight._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class CharacterTest {

  @DisplayName("변경 후 플라이웨이트 패턴 테스트")
  @Test
  void testFlyweight() {
    FontFactory fontFactory = new FontFactory();
    Character c1 = new Character('h', "white", fontFactory.getFont("nanum:12"));
    Character c2 = new Character('e', "white", fontFactory.getFont("nanum:12"));
    Character c3 = new Character('l', "white", fontFactory.getFont("nanum:12"));

    log.debug("{}", c1);
    log.debug("{}", c2);
    log.debug("{}", c3);
  }

}
