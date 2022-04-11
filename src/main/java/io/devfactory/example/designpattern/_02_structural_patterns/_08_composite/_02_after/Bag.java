package io.devfactory.example.designpattern._02_structural_patterns._08_composite._02_after;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Bag implements Component {

  private final List<Component> components = new ArrayList<>();

  public void add(Component component) {
    components.add(component);
  }

  @Override
  public int getPrice() {
    return components.stream().mapToInt(Component::getPrice).sum();
  }

}
