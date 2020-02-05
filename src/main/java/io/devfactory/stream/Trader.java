package io.devfactory.stream;

import java.util.StringJoiner;

public class Trader {

    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Trader.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("city='" + city + "'")
                .toString();
    }

}
