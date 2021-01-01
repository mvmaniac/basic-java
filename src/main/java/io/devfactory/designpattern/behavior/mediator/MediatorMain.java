package io.devfactory.designpattern.behavior.mediator;

import io.devfactory.designpattern.behavior.mediator.service.Server;
import io.devfactory.designpattern.behavior.mediator.service.User;
import lombok.extern.slf4j.Slf4j;

// 중재자 패턴 (Mediator Pattern)
// 분산된 다수의 객체 역할을 조정할 때 주로 사용
// 중재자는 객체 간 복잡한 상호 관계를 중재하며 객체 간에 복잡한 관계로 묶인 것을 재구성 함
// 서로 의존적은 M:N의 관계를 가진 객체를 느슨한 1:1 꽌게로 변경함
// 객체의 관계를 하나의 객체로 정리하는 패턴임
// 하나의 중재자와 동료 객체로 구성되어 있으며, 동료 객체의 강력한 결합 구조를 느슨한 결합 구조로 개선함
// 각각의 동료 객체가 서로 통신하는 것이 아니라 중재자를 통해 통신하는 것임
@Slf4j
public class MediatorMain {

  public static void main(String[] args) {
    // 서버 생성
    final Server mediator = new Server();

    // Colleague 1 등록
    final User user1 = new User("james");
    user1.changeMediator(mediator);
    mediator.addColleague(user1);

    // Colleague 2 등록
    final User user2 = new User("jin");
    user2.changeMediator(mediator);
    mediator.addColleague(user2);

    // Colleague 3 등록
    final User user3 = new User("eric");
    user3.changeMediator(mediator);
    mediator.addColleague(user3);

    // 중재자로 데이터 전송
    user1.send("안녕하세요. 저는 james 입니다.");
    log.debug("");

    user2.send("안녕하세요. 저는 jin 입니다.");
    log.debug("");

    user3.send("안녕하세요. 저는 eric 입니다.");
    log.debug("");
  }

}
