package io.devfactory.example.designpattern._02_structural_patterns._08_composite._02_after;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class BagTest {

  @DisplayName("변경 후 컴포짓 패턴 테스트")
  @Test
  void testComposite() {
    Item doranBlade = new Item("도란검", 450);
    Item healPotion = new Item("체력 물약", 50);

    Bag bag = new Bag();
    bag.add(doranBlade);
    bag.add(healPotion);

    printPrice(doranBlade);
    printPrice(bag);
  }

  private void printPrice(Component component) {
    log.debug("{}", component.getPrice());
  }

}
