package io.devfactory.reactive.flow;

import io.devfactory.reactive.TempInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

@Slf4j
public class TempSubscriber implements Subscriber<TempInfo> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        // 구독을 지정하고 첫 번째 요청을 전달
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(TempInfo tempInfo) {
        // 수신한 온도를 출력하고 다음 정보를 요청
        log.debug("[dev] TempSubscriber next temp: {}", tempInfo);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        // 에러가 발생하면 에러 메세지 출력
        log.error(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        log.debug("[dev] TempSubscriber Done!");
    }

}
