package io.devfactory.example.designpattern._02_structural_patterns._08_composite._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class BagTest {

  @DisplayName("변경 전 컴포짓 패턴 테스트")
  @Test
  void testComposite() {
    Item doranBlade = new Item("도란검", 450);
    Item healPotion = new Item("체력 물약", 50);

    Bag bag = new Bag();
    bag.add(doranBlade);
    bag.add(healPotion);

    printPrice(doranBlade);
    printPrice(healPotion);
  }

  private void printPrice(Item item) {
    log.debug("{}", item.getPrice());
  }

  private void printPrice(Bag bag) {
    int sum = bag.getItems().stream().mapToInt(Item::getPrice).sum();
    log.debug("{}", sum);
  }

}
