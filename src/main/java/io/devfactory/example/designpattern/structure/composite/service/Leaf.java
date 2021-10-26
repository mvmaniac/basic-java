package io.devfactory.example.designpattern.structure.composite.service;

import io.devfactory.example.designpattern.structure.composite.Component;
import lombok.Getter;
import lombok.Setter;

// 컴포넌트 추상화를 적용
@Getter
@Setter
public class Leaf extends Component {

  private String data;

  public Leaf(String name) {
    this.setName(name);
  }

}
