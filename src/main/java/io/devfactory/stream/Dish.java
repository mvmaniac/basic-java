package io.devfactory.stream;

import java.util.StringJoiner;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final DishType dishType;

    public Dish(String name, boolean vegetarian, int calories, DishType dishType) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.dishType = dishType;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public DishType getDishType() {
        return dishType;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dish.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("vegetarian=" + vegetarian)
                .add("calories=" + calories)
                .add("dishType=" + dishType)
                .toString();
    }

}
