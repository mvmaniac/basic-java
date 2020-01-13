package io.devfactory.optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Slf4j
class OptTest {

    @DisplayName("자동차의 보험회사 이름 찾기")
    @ParameterizedTest(name = "{index}, {displayName}, message={0},{1}")
    @CsvSource({"1,insurance-1", "1,null", "2,null", "3,null", "4,null"})
    void 자동차의_보험회사_이름_찾기(@AggregateWith(OptAggregator.class) OptPerson person) {
        log.debug("[dev] person: {}", Opt.getCarInsuranceName(Optional.ofNullable(person)));
    }
    
    @DisplayName("자동차의_보험회사_이름_목록_찾기")
    @Test
    void 자동차의_보험회사_이름_목록_찾기() {
        // @formatter:off
        // 만약 OptPerson 자체가 null 인 경우에는
        // stream 으로 순회 시 filter(Objects::nonNull) 로 체크가 필요 할 듯...
        final List<OptPerson> persons = List.of(
            getPerson(3, "null"),
            getPerson(1, "default-2"),
            getPerson(1, "default-3"),
            getPerson(2, "null"),
            getPerson(1, "default-1"),
            getPerson(1, "null")
        );
        // @formatter:on
        log.debug("[dev] person: {}", Opt.getCarInsuranceNames(persons));
    }

    @DisplayName("프로퍼티_값_읽기")
    @Test
    void 프로퍼티_값_읽기() {
        final Properties properties = new Properties();
        properties.setProperty("a", "5");
        properties.setProperty("b", "true");
        properties.setProperty("c", "-1");
        properties.setProperty("d", "0");
        properties.setProperty("e", "3");

        // @formatter:off
        properties.forEach((k, v) ->
            log.debug("[dev] key:{}, value:{}", k, Opt.readDuration(properties, String.valueOf(k)))
        );
        // @formatter:on
    }

    static class OptAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            final int type = accessor.getInteger(0);
            final String value = accessor.getString(1);

            return getPerson(type, value);
        }
    }

    private static OptPerson getPerson(int type, String value) {
        OptPerson person = new OptPerson(new OptCar(new OptInsurance("default")));

        switch (type) {
            case 1:
                person = new OptPerson(new OptCar(new OptInsurance("null".equals(value) ? null : value)));
                break;
            case 2:
                person = new OptPerson(new OptCar(null));
                break;
            case 3:
                person = new OptPerson(null);
                break;
            case 4:
                person = null;
                break;
        }

        return person;
    }

}