package io.devfactory.example.modernjava.reactive.flow;

import static io.devfactory.example.modernjava.reactive.flow.FlowMain.getTemperature;
import static io.devfactory.example.modernjava.reactive.flow.FlowMain.getTemperatureWithProcessor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("squid:S2699")
class FlowMainTest {

  @DisplayName("온도_정보_가져오기")
  @Test
  void 온도_정보_가져오기() {
    // 새 Publisher 를 만들고 TempSubscriber 를 구독시킴
    getTemperature("New York").subscribe(new TempSubscriber());
  }

  @DisplayName("온도_정보를_섭씨로_가져오기")
  @Test
  void 온도_정보를_섭씨로_가져오기() {
    // 새 Publisher 를 만들고 TempSubscriber 를 구독시킴
    getTemperatureWithProcessor("New York").subscribe(new TempSubscriber());
  }

}
