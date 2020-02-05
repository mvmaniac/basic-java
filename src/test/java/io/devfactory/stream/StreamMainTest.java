package io.devfactory.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static io.devfactory.stream.StreamMain.*;

@SuppressWarnings("squid:S2699")
@Slf4j
class StreamMainTest {

    private Consumer<Object> logDev = o -> log.debug("[dev] {}", o);

    @DisplayName("스트림_테스트")
    @Test
    void 스트림_테스트() {
        log.debug("[dev] getHighCaloricDishNames");
        getHighCaloricDishNames(3).forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");

        log.debug("[dev] getVegetarianDish");
        getVegetarianDish().forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");

        log.debug("[dev] getLessThanCalories_320");
        getLessThanCalories_320().forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");

        log.debug("[dev] getGreaterThanCalories_320");
        getGreaterThanCalories_320().forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");

        log.debug("[dev] getPairNumbers");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        getPairNumbers(numbers1, numbers2).forEach(logDev);
        log.debug("[dev] ---------------------------------------------------");

        log.debug("[dev] getDishCountByMapReduce: {}", getDishCountByMapReduce());
        log.debug("[dev] ---------------------------------------------------");
    }

}