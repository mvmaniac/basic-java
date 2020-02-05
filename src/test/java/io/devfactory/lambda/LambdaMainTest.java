package io.devfactory.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static io.devfactory.lambda.LambdaMain.*;
import static java.util.Comparator.comparingInt;

@SuppressWarnings("squid:S2699")
@Slf4j
class LambdaMainTest {

    private Consumer<Apple> logDev = apple -> log.debug("[dev] {}", apple);

    @DisplayName("람다_테스트")
    @Test
    void 람다_테스트() {
        // @formatter:off
        final List<Apple> inventory = Arrays.asList(
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

        log.debug("");

        inventory.sort((a, b) -> a.getWeight() - b.getWeight());
        inventory.forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");
        inventory.sort(comparingInt(Apple::getWeight));
        inventory.forEach(logDev);
    }

}