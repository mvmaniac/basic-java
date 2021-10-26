package io.devfactory.example.designpattern.structure.composite;

import io.devfactory.example.designpattern.structure.composite.service.Composite;
import io.devfactory.example.designpattern.structure.composite.service.Leaf;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

// 복합체 패턴 (Composite Pattern)
// 객체 간의 계층적 구조화를 통해 객체를 확장하는 패턴
// 복합체는 재귀적으로 결합된 계층화된 트리 구조의 객체
// 복합 객체는 객체가 또 다른 객체를 포함하는 것을 말하는데 복합적인 객체 관계를 복합화(Composition) 또는 집단화(Aggregation) 라고 함
// 복합체 패턴을 적용한 예로 파일 탐색, 조직도 등이 있음
// 복합체는 하나의 구조 안에 또 다른 구조를 가진 모델을 설계할 때 많이 사용됨
// 복합체 패턴은 크게 4개의 구성요소로 이루어짐 (Component, Composite, Leaf, Client)
// 복합체 패턴은 객체지향의 단일 책임 원칙을 위반하는 패턴 중 하나
@Slf4j
public class CompositeMain {

  public static void main(String[] args) {
    // 폴더
    Composite root = new Composite("root");
    Composite home = new Composite("home");
    Composite jin = new Composite("jin");
    Composite jun = new Composite("jun");
    Composite users = new Composite("users");
    Composite temp = new Composite("temp");

    // 파일
    Leaf img1 = new Leaf("img1");
    Leaf img2 = new Leaf("img2");
    Leaf img3 = new Leaf("img3");
    Leaf img4 = new Leaf("img4");

    // 상단에 서브 컴포넌트(폴더)를 추가
    root.addNode(home);
    root.addNode(users);
    root.addNode(temp);

    // 서브폴더 추가
    users.addNode(jin);
    users.addNode(jun);

    // 파일(leaf) 추가
    jin.addNode(img1);
    jin.addNode(img2);
    jin.addNode(img3);
    jin.addNode(img4);

    // 복합체 패턴 노드 트리를 출력
    tree(root);
    
    // 노드를 하나 제거
    log.debug("");
    log.debug("remove node");

    users.removeNode(jin);
    tree(root);
  }

  public static void tree(Composite composite) {
    final List<Component> components = composite.getComponents();

    for (Component component : components) {
      if (component instanceof Composite) {
        Composite findComposite = (Composite) component;

        if (findComposite.isNode()) {
          log.debug("Folder = {}", findComposite.getName());

          // 재귀호출 탐색
          tree(findComposite);
        } else {
          log.debug("Folder = {} ...노드 없음", findComposite.getName());
        }

      } else if (component instanceof Leaf) {
        Leaf findLeaf = (Leaf) component;
        log.debug("File = {}", findLeaf.getName());

      } else {
        log.debug("??");
      }
    }
  }

}
