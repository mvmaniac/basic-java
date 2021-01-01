package io.devfactory.designpattern.behavior.status;

import io.devfactory.designpattern.behavior.status.service.JinOrder;
import io.devfactory.designpattern.behavior.status.service.LightLamp;
import lombok.extern.slf4j.Slf4j;

// 상태 패턴 (Status Pattern)
// 조건에 따른 별개의 동작을 제어문으로 사용하지 않음
// 그 대신 캑체를 캡슐화하여 독립된 동작으로 구분하는 패턴으로 상패 표현 객체(object for state)라고 부르기도 함
// 상태 패턴은 구조적으로 전략 패턴과 매우 유사한데 두 패턴 모두 런타임으로 객체를 위힘해 동작을 변경
// 전략 패턴은 위임된 객체를 알고리즘으로 생각하지만, 상태 패턴에서는 위임된 객체를 상태값의 처리로 생각함
// 전략 패턴은 객체의 상태 값에 관심이 없으며, 알고리즘을 교체하고 동작을 변경시키는 것만 생각함
// 상태 패턴은 동작하는 객체의 변경이 상테에 따라 달라짐, 상태값이 매우 중요하며 다음 동작과 객체의 위임을 결정함
@Slf4j
public class StatusMain {

  public static void main(String[] args) {
    final JinOrder order = new JinOrder();
    order.process("ORDERED");

    final LightLamp lightLamp = new LightLamp();
    log.debug("{}", lightLamp.lightOn().lightState());
    log.debug("{}", lightLamp.lightOff().lightState());
    log.debug("{}", lightLamp.lightOn().lightState());
    log.debug("{}", lightLamp.lightOn().lightState());
  }

}
