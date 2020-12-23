package io.devfactory.designpattern.structure.composite.service;

import io.devfactory.designpattern.structure.composite.Component;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Composite extends Component {

  private final List<Component> components;

  public Composite(String name) {
    components = new ArrayList<>();
    this.setName(name);
  }

  // 요소를 추가
  public void addNode(Component folder) {
    this.components.add(folder);
  }

  // 요소를 제거
  public void removeNode(Component component) {
    this.components.remove(component);
  }

  // 노드 확인
  public boolean isNode() {
    return !components.isEmpty();
  }

}
