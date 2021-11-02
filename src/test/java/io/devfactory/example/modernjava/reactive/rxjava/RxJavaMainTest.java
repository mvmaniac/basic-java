package io.devfactory.example.modernjava.reactive.rxjava;

import io.devfactory.example.modernjava.reactive.TempInfo;
import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.devfactory.example.modernjava.reactive.rxjava.RxJavaMain.*;

@SuppressWarnings("squid:S2699")
class RxJavaMainTest {

  @DisplayName("온도_정보_가져오기")
  @Test
  void 온도_정보_가져오기() {
    // 매 초마다 온도 보고를 방출하는 Observable 를 만듬
    final Observable<TempInfo> observable = getTemperature("New York");

    // 단순 Observer 로 이 Observable 에 가입해서 온도 출력
    // subscribe 는 데몬 스레드에서 실행 되기 때문에 프로그램이 종료되면 바로 종료 되므로
    // 예제에서는 blockingSubscribe 를 사용함
    observable.blockingSubscribe(new TempObserver());
  }

  @DisplayName("온도_정보를_섭씨로_가져오기")
  @Test
  void 온도_정보를_섭씨로_가져오기() {
    // 매 초마다 온도 보고를 방출하는 Observable 를 만듬
    final Observable<TempInfo> observable = getCelsiusTemperature("New York");

    // 단순 Observer 로 이 Observable 에 가입해서 온도 출력
    // subscribe 는 데몬 스레드에서 실행 되기 때문에 프로그램이 종료되면 바로 종료 되므로
    // 예제에서는 blockingSubscribe 를 사용함
    observable.blockingSubscribe(new TempObserver());
  }

  @DisplayName("온도_정보를_섭씨로_가져오되_영하_온도만_가져오기")
  @Test
  void 온도_정보를_섭씨로_가져오되_영하_온도만_가져오기() {
    // 매 초마다 온도 보고를 방출하는 Observable 를 만듬
    final Observable<TempInfo> observable = getNegativeTemperature("New York");

    // 단순 Observer 로 이 Observable 에 가입해서 온도 출력
    // subscribe 는 데몬 스레드에서 실행 되기 때문에 프로그램이 종료되면 바로 종료 되므로
    // 예제에서는 blockingSubscribe 를 사용함
    observable.blockingSubscribe(new TempObserver());
  }

  @DisplayName("여러_도시의_온도_정보_가져오기")
  @Test
  void 여러_도시의_온도_정보_가져오기() {
    // 매 초마다 온도 보고를 방출하는 Observable 를 만듬
    final Observable<TempInfo> observable = getCelsiusTemperatures("New York", "Chicago",
        "San Francisco");

    // 단순 Observer 로 이 Observable 에 가입해서 온도 출력
    // subscribe 는 데몬 스레드에서 실행 되기 때문에 프로그램이 종료되면 바로 종료 되므로
    // 예제에서는 blockingSubscribe 를 사용함
    observable.blockingSubscribe(new TempObserver());
  }

}
