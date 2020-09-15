package io.devfactory.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamMain {

    private static final List<Dish> menu;
    private static final List<Dish> orderedMenu;

    static {
        // @formatter:off
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

        orderedMenu = Arrays.asList(
            new Dish("season fruit", true, 120, DishType.OTHER),
            new Dish("prawns", false, 300, DishType.FISH),
            new Dish("potato", false, 320, DishType.FISH),
            new Dish("rice", true, 350, DishType.OTHER),
            new Dish("chicken", false, 400, DishType.MEAT),
            new Dish("french fries", true, 530, DishType.OTHER)
        );
        // @formatter:on
    }

    private StreamMain() {}

    // filter, map, limit 은 중간연산으로
    // 중간연산을 합친 다음에 합쳐진 중간연산을 최종연산으로 한 번에 처리됨
    // 즉, 게으르게(lazy) 처리
    @SuppressWarnings({"squid:S106", "squid:S3864"})
    public static List<String> getHighCaloricDishNames(int limit) {
        // @formatter:off
        return menu.stream()
            .filter(dish -> dish.getCalories() > 300)
                .peek(dish -> System.out.printf("filter after: %s%n", dish))
            .map(Dish::getName)
                .peek(dish -> System.out.printf("map after: %s%n", dish))
            .limit(limit)
                .peek(dish -> System.out.printf("limit after: %s%n", dish))
            .collect(toList())
        ;
        // @formatter:on
    }

    public static List<Dish> getVegetarianDish() {
        // @formatter:off
        return menu.stream()
            .filter(Dish::isVegetarian)
            .collect(toList())
        ;
        // @formatter:on
    }

    // takeWhile() 은 해당 조건에 맞는 것만 가져옴
    // 가져올 기준으로 졍렬되어 있는 경우 사용
    // 샘플 목록은 칼로리 순으로 정렬 되어 있음
    @SuppressWarnings("squid:S00100")
    public static List<Dish> getLessThanCalories_320() {
        // @formatter:off
        return orderedMenu.stream()
            .takeWhile(dish -> dish.getCalories() < 320)
            .collect(toList())
        ;
        // @formatter:on
    }

    // dropWhile() 은 해당 조건에 맞지 않는 것만 가져옴
    // 가져올 기준으로 졍렬되어 있는 경우 사용
    // 샘플 목록은 칼로리 순으로 정렬 되어 있음
    @SuppressWarnings("squid:S00100")
    public static List<Dish> getGreaterThanCalories_320() {
        // @formatter:off
        return orderedMenu.stream()
            .dropWhile(dish -> dish.getCalories() < 320)
            .collect(toList())
        ;
        // @formatter:on
    }

    // 두개의 숫자 리스트가 있을 때 모든 숫자쌍의 리스트를 반환
    // 예를들어 [1,2,3]과 [3,4]가 주어지면 [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]를 반환
    public static List<int[]> getPairNumbers(List<Integer> numbers1, List<Integer> numbers2) {
        // @formatter:off
        return numbers1.stream()
            .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
            .collect(toList())
        ;
        // @formatter:on
    }

    // 맵 리듀스 패턴
    public static int getDishCountByMapReduce() {
        // @formatter:off
        return menu.stream()
            .map(dish -> 1)
            //.reduce(0, (a, b) -> a + b) or
            .reduce(0, Integer::sum)
        ;
        // @formatter:on
    }

}
