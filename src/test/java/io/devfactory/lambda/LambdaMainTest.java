package io.devfactory.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static io.devfactory.lambda.LambdaMain.filterApplesByColor;
import static io.devfactory.lambda.LambdaMain.filterApplesByWeight;
import static io.devfactory.lambda.LambdaMain.filterApples;
import static io.devfactory.lambda.LambdaMain.filter;

@SuppressWarnings("squid:S2699")
@Slf4j
class LambdaMainTest {

    private Consumer<Apple> logDev = apple -> log.debug("[dev] {}", apple);

    @DisplayName("람다_테스트")
    @Test
    void 람다_테스트() {
        // @formatter:off
        final List<Apple> inventory = List.of(
            new Apple(80, Color.GREEN),
            new Apple(120, Color.RED),
            new Apple(155, Color.GREEN)
        );
        // @formatter:on

        filterApplesByColor(inventory, Color.GREEN).forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");
        filterApplesByWeight(inventory, 100).forEach(logDev);

        log.debug("");

        filterApples(inventory, apple -> Color.RED.equals(apple.getColor())).forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");
        filterApples(inventory, apple -> apple.getWeight() >= 150).forEach(logDev);

        log.debug("");

        filter(inventory, apple -> Color.RED.equals(apple.getColor())).forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");
        filter(inventory, apple -> apple.getWeight() >= 150).forEach(logDev);
    }

}