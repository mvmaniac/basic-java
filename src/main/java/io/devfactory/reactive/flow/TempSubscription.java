package io.devfactory.reactive.flow;

import io.devfactory.reactive.TempInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TempSubscription implements Subscription {

  private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

  private final Subscriber<? super TempInfo> subscriber;
  private final String town;

  public TempSubscription(Subscriber<? super TempInfo> subscriber, String town) {
    this.subscriber = subscriber;
    this.town = town;
  }

  @Override
  public void request(long n) {
    // 다른 스레드에서 다음 요소를 구독자에게 보냄
    EXECUTOR_SERVICE.submit(() -> {
      // Subscriber 가 만든 요청을 한 개씩 반복
      for (long i = 0L; i < n; i++) {
        try {
          // 현재 온도를 Subscriber 로 전달
          subscriber.onNext(TempInfo.fetch(town));
        } catch (Exception e) {
          // 온도 가져오기를 실패하면 Subscriber 로 에러를 전달
          subscriber.onError(e);
          break;
        }
      }
    });
  }

  @Override
  public void cancel() {
    // 구독이 취소되면 완료 신호를 Subscriber 로 전달
    subscriber.onComplete();
  }

}
