package io.devfactory.reactive.flow;

import io.devfactory.reactive.TempInfo;

import java.util.concurrent.Flow.Publisher;

public class FlowMain {

    private FlowMain() {}

    public static Publisher<TempInfo> getTemperature(String town) {
        // 구독한 Subscriber 에게 TempSubscription 를 전송하는 Publisher 를 반환
        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }

    public static Publisher<TempInfo> getTemperatureWithProcessor(String town) {
        // TempProcessor 를 만들고 Subscriber 와 반환된 Publisher 사이로 연결
        return subscriber -> {
            final TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }

}
