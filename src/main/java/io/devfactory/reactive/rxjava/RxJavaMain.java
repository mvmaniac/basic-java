package io.devfactory.reactive.rxjava;

import static java.util.stream.Collectors.toList;

import io.devfactory.reactive.TempInfo;
import io.reactivex.Observable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class RxJavaMain {

  private RxJavaMain() {
  }

  public static Observable<TempInfo> getTemperature(String town) {
    // @formatter:off
        // Observer 를 소비하는 Observable 만들기
        return Observable.create(emitter ->
            // 매 초마다 무한으로 증가하는 일련의 long 값을 방출하는 Observable
            Observable.interval(1, TimeUnit.SECONDS).subscribe(
                i -> {
                    // 소비된 옵저버가 아직 폐기 되지 않았으면
                    // 어떤 작업을 수행함 (이전에러)
                    if (!emitter.isDisposed()) {
                        // 온도를 다섯 번 보고했으면 옵저버를 완료하고 스트림을 종료
                        if (i >= 5) {
                            emitter.onComplete();
                        } else {
                            try {
                                // 아니면 온도를 Observer 로 보고
                                emitter.onNext(TempInfo.fetch(town));

                            } catch (Exception e) {
                                // 에러가 발생하면 Observer 에게 알림
                                emitter.onError(e);
                            }
                        }
                    }
                }
            )
        );
        // @formatter:on
  }

  public static Observable<TempInfo> getCelsiusTemperature(String town) {
    return getTemperature(town)
        .map(temp -> new TempInfo(temp.getTown(), (temp.getTemp() - 32) * 5 / 9));
  }

  public static Observable<TempInfo> getNegativeTemperature(String town) {
    return getCelsiusTemperature(town).filter(temp -> temp.getTemp() < 0);
  }

  public static Observable<TempInfo> getCelsiusTemperatures(String... towns) {
    return Observable
        .merge(Arrays.stream(towns).map(RxJavaMain::getCelsiusTemperature).collect(toList()));
  }

}
