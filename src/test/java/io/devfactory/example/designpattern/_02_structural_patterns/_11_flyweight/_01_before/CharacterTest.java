package io.devfactory.example.designpattern._02_structural_patterns._11_flyweight._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class CharacterTest {

  @DisplayName("변경 전 플라이웨이트 패턴 테스트")
  @Test
  void testFlyweight() {
    Character c1 = new Character('h', "white", "Nanum", 12);
    Character c2 = new Character('e', "white", "Nanum", 12);
    Character c3 = new Character('l', "white", "Nanum", 12);
    Character c4 = new Character('l', "white", "Nanum", 12);
    Character c5 = new Character('o', "white", "Nanum", 12);

    log.debug("{}", c1);
    log.debug("{}", c2);
    log.debug("{}", c3);
    log.debug("{}", c4);
    log.debug("{}", c5);
  }

}
