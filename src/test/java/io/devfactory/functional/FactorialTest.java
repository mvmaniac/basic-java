package io.devfactory.functional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.devfactory.functional.Factorial.*;

@SuppressWarnings("squid:S2699")
@Slf4j
class FactorialTest {

    @DisplayName("팩토리얼_테스트")
    @Test
    void 팩토리얼_테스트() {
        log.debug("[dev] factorialIterative: {}", factorialIterative(5));
        log.debug("[dev] factorialRecursive: {}", factorialRecursive(5));
        log.debug("[dev] factorialStreams: {}", factorialStreams(5));
        log.debug("[dev] factorialTailRecursive: {}", factorialTailRecursive(5));
    }

}