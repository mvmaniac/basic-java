package io.devfactory.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

@SuppressWarnings("squid:S2699")
@Slf4j
class CurrencyExchangeTest {

    private enum CaloricLevel {DIET, NORMAL, FAT}

    private static List<Integer> numbers;
    private static List<Dish> menu;
    private static List<CurrencyExchange> currencyExchanges;
    private static Map<String, List<String>> dishTags;

    private Consumer<Object> logDev = o -> log.debug("[dev] {}", o);
    private BinaryOperator<String> stringJoin = (s1, s2) -> {
        if (StringUtils.isEmpty(s1)) {
            return s2;
        }
        return String.format("%s, %s", s1, s2);
    };

    @BeforeAll
    static void setUp() {
        // @formatter:off
        numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        menu = Arrays.asList(
            new Dish("pork", false, 800, DishType.MEAT),
            new Dish("beef", false, 700, DishType.MEAT),
            new Dish("chicken", false, 400, DishType.MEAT),
            new Dish("french fries", true, 530, DishType.OTHER),
            new Dish("rice", true, 350, DishType.OTHER),
            new Dish("season fruit", true, 120, DishType.OTHER),
            new Dish("pizza", true, 550, DishType.OTHER),
            new Dish("prawns", false, 400, DishType.FISH),
            new Dish("salmon", false, 450, DishType.FISH)
        );

        currencyExchanges = Arrays.asList(
            new CurrencyExchange(Currency.EUR, 1500.0),
            new CurrencyExchange(Currency.USD, 2300.0),
            new CurrencyExchange(Currency.GBP, 9900.0),
            new CurrencyExchange(Currency.EUR, 1100.0),
            new CurrencyExchange(Currency.JPY, 7800.0),
            new CurrencyExchange(Currency.CHF, 6700.0),
            new CurrencyExchange(Currency.EUR, 5600.0),
            new CurrencyExchange(Currency.USD, 4500.0),
            new CurrencyExchange(Currency.CHF, 3400.0),
            new CurrencyExchange(Currency.GBP, 3200.0),
            new CurrencyExchange(Currency.USD, 4600.0),
            new CurrencyExchange(Currency.JPY, 5700.0),
            new CurrencyExchange(Currency.EUR, 6800.0)
        );

        dishTags = Map.ofEntries(
            Map.entry("pork", List.of("greasy", "salty")),
            Map.entry("beef", List.of("salty", "roasted")),
            Map.entry("chicken", List.of("fried", "crisp")),
            Map.entry("french fries", List.of("greasy", "fried")),
            Map.entry("rice", List.of("light", "natural")),
            Map.entry("season fruit", List.of("fresh", "natural")),
            Map.entry("pizza", List.of("tasty", "salty")),
            Map.entry("prawns", List.of("tasty", "roasted")),
            Map.entry("salmon", List.of("delicious", "fresh"))
        );
        // @formatter:on
    }

    @SuppressWarnings("Java8MapApi")
    @DisplayName("통화별로 그룹화 할 수 있다")
    @Test
    void 통화별로_그룹화_할_수_있다() {
        // 명령형 버전
        Map<Currency, List<CurrencyExchange>> exchangeByCurrencies = new HashMap<>();

        for (CurrencyExchange exchange : currencyExchanges) {
            Currency currency = exchange.getCurrency();

            List<CurrencyExchange> exchangeForCurrency = exchangeByCurrencies.get(currency);

            if (exchangeForCurrency == null) {
                exchangeForCurrency = new ArrayList<>();
                exchangeByCurrencies.put(currency, exchangeForCurrency);
            }

            exchangeForCurrency.add(exchange);
        }

        log.debug("[dev] Imperatively");
        exchangeByCurrencies.entrySet().forEach(logDev);

        log.debug("[dev] ---------------------------------------------------");

        // 스트림 버전
        // @formatter:off
        log.debug("[dev] Functionally");
        currencyExchanges.stream()
            .collect(groupingBy(CurrencyExchange::getCurrency))
            .entrySet()
            .forEach(logDev);
        // @formatter:on
    }

    @SuppressWarnings("SimplifyStreamApiCallChains")
    @DisplayName("요약 연산을 할 수 있다")
    @Test
    void 요약_연산을_할_수_있다() {
        final int sum1 = numbers.stream().mapToInt(n -> n).sum();
        final int sum2 = numbers.stream().reduce(0, Integer::sum);
        final int sum3 = numbers.stream().collect(summingInt(n -> n));
        final int sum4 = numbers.stream().collect(reducing(0, n -> n, Integer::sum)); // 초깃값, 변환함수, 합계함수 (한개 인수로도 됨)

        final int max1 = numbers.stream().reduce(0, Integer::max);
        final int max2 = numbers.stream().max(Integer::compareTo).orElse(0);
        final int max3 = numbers.stream().collect(maxBy(Integer::compareTo)).orElse(0);
        final int max4 = numbers.stream().collect(reducing(0, n -> n, Integer::max));

        log.debug("[dev] sum: {}, {}, {}, {}", sum1, sum2, sum3, sum4);
        log.debug("[dev] max: {}, {}, {}, {}", max1, max2, max3, max4);
        log.debug("[dev] ---------------------------------------------------");

        final int totalCalories1 = menu.stream().mapToInt(Dish::getCalories).sum();
        final int totalCalories2 = menu.stream().collect(summingInt(Dish::getCalories));
        final int totalCalories3 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));

        log.debug("[dev] totalCalories: {}, {}, {}", totalCalories1, totalCalories2, totalCalories3);
        log.debug("[dev] ---------------------------------------------------");

        final double avgCalories1 = menu.stream().collect(averagingInt(Dish::getCalories));
        final double avgCalories2 = menu.stream().mapToInt(Dish::getCalories).average().orElse(0.0);

        log.debug("[dev] avgCalories: {}, {}", avgCalories1, avgCalories2);
        log.debug("[dev] ---------------------------------------------------");

        final IntSummaryStatistics statistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        log.debug("[dev] statistics: {}", statistics);
    }

    @SuppressWarnings("SimplifyStreamApiCallChains")
    @DisplayName("문자열 연결를 할 수 있다")
    @Test
    void 문자열_연결를_할_수_있다() {
        final String shortMenu1 = menu.stream().map(Dish::getName).collect(joining(", "));
        final String shortMenu2 = menu.stream().map(Dish::getName).reduce("", stringJoin);
        final String shortMenu3 = menu.stream().map(Dish::getName).collect(reducing(stringJoin)).orElse("");
        final String shortMenu4 = menu.stream().collect(reducing("", Dish::getName, stringJoin));
        log.debug("[dev] shortMenu1: {}", shortMenu1);
        log.debug("[dev] shortMenu2: {}", shortMenu2);
        log.debug("[dev] shortMenu3: {}", shortMenu3);
        log.debug("[dev] shortMenu4: {}", shortMenu4);
    }

    @DisplayName("그룹화를 할 수 있다")
    @Test
    void 그룹화를_할_수_있다() {
        // @formatter:off
        log.debug("[dev] dishesByType");
        log.debug("[dev]");

        final Map<DishType, List<Dish>> dishesByType = menu.stream().collect(
                groupingBy(Dish::getDishType)
        );

        dishesByType.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] dishesByCaloricLevel");
        log.debug("[dev]");

        final Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
            groupingBy(this::getCaloricLevel)
        );

        dishesByCaloricLevel.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] caloricDishesByType");
        log.debug("[dev]");

        final Map<DishType, List<Dish>> caloricDishesByType = menu.stream().collect(
            groupingBy(Dish::getDishType,
                filtering(dish -> dish.getCalories() > 500, toList())
            )
        );

        caloricDishesByType.entrySet().forEach(logDev); // fish 처럼 그룹화 된 데이터가 없어도 나옴
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] dishNamesByType");
        log.debug("[dev]");

        final Map<DishType, List<String>> dishNamesByType = menu.stream().collect(
            groupingBy(Dish::getDishType,
                mapping(Dish::getName, toList())
            )
        );

        dishNamesByType.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] dishTagNamesByType");
        log.debug("[dev]");

        final Map<DishType, Set<String>> dishTagNamesByType = menu.stream().collect(
            groupingBy(Dish::getDishType,
                flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())
            )
        );

        dishTagNamesByType.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] dishesByTypeCaloricLevel");
        log.debug("[dev]");

        final Map<DishType, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
            groupingBy(Dish::getDishType, // 첫 번째 수준의 분류 함수
                groupingBy(this::getCaloricLevel) // 두 번째 수준의 분류 함수
            )
        );

        dishesByTypeCaloricLevel.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] typesCount");
        log.debug("[dev]");

        final Map<DishType, Long> typesCount = menu.stream().collect(
            groupingBy(Dish::getDishType,
                counting()
            )
        );

        typesCount.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] mostCaloricByType");
        log.debug("[dev]");

        final Map<DishType, Dish> mostCaloricByType1 = menu.stream().collect(
            groupingBy(Dish::getDishType, // 분류 함수
                collectingAndThen(
                    maxBy(comparingInt(Dish::getCalories)), // 감싸인 컬렉터
                    Optional::get  // 변환 함수
                )
            )
        );

        final Map<DishType, Dish> mostCaloricByType2 = menu.stream().collect(
            toMap(Dish::getDishType, Function.identity(), BinaryOperator.maxBy(comparingInt(Dish::getCalories)))
        );

        mostCaloricByType1.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] totalCaloriesByType");
        log.debug("[dev]");

        final Map<DishType, Integer> totalCaloriesByType = menu.stream().collect(
            groupingBy(Dish::getDishType,
                summingInt(Dish::getCalories)
            )
        );

        totalCaloriesByType.entrySet().forEach(logDev);
        // @formatter:on
    }
    
    @DisplayName("분할을 할 수 있다")
    @Test
    void 분할을_할_수_있다() {
        // @formatter:off
        log.debug("[dev] partitionedMenu");
        log.debug("[dev]");

        final Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(
            partitioningBy(Dish::isVegetarian)
        );

        //final List<Dish> vegetarianDishes = partitionedMenu.get(true);
        //final List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());

        partitionedMenu.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] vegetarianDishesByType");
        log.debug("[dev]");

        final Map<Boolean, Map<DishType, List<Dish>>> vegetarianDishesByType = menu.stream().collect(
            partitioningBy(Dish::isVegetarian,
                groupingBy(Dish::getDishType)
            )
        );

        vegetarianDishesByType.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] vegetarianDishesByType");
        log.debug("[dev]");

        final Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream().collect(
            partitioningBy(Dish::isVegetarian,
                collectingAndThen(
                    maxBy(comparingInt(Dish::getCalories)), Optional::get
                )
            )
        );

        mostCaloricPartitionedByVegetarian.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] vegetarianDishesByTypeOver500");
        log.debug("[dev]");

        final Map<Boolean, Map<Boolean, List<Dish>>> vegetarianDishesByTypeOver500 = menu.stream().collect(
            partitioningBy(Dish::isVegetarian,
                partitioningBy(dish -> dish.getCalories() > 500)
            )
        );

        vegetarianDishesByTypeOver500.entrySet().forEach(logDev);
        // @formatter:on

        // @formatter:off
        log.debug("[dev] ---------------------------------------------------");
        log.debug("[dev] vegetarianDishesByTypeOver500");
        log.debug("[dev]");

        final Map<Boolean, Long> vegetarianDishesByCount = menu.stream().collect(
            partitioningBy(Dish::isVegetarian,
                counting()
            )
        );

        vegetarianDishesByCount.entrySet().forEach(logDev);
        // @formatter:on
    }

    private CaloricLevel getCaloricLevel(Dish dish) {
        if (dish.getCalories() <= 400) return CaloricLevel.DIET;
        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
        else return CaloricLevel.FAT;
    }

}