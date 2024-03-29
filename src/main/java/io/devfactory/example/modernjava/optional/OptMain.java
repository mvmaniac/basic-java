package io.devfactory.example.modernjava.optional;

import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

public class OptMain {

  private OptMain() {
  }

  public static String getCarInsuranceName(Optional<OptPerson> person) {
    // Optional 으로 조작
    // map 이 아닌 flatMap 으로
    // map 으로 할 경우 Optional<Optional<OptCar>>
    // flatMap 으로 할 경우 Optional<OptCar> 로 반환 됨
    return person.flatMap(OptPerson::getCarAsOptional)
        .flatMap(OptCar::getInsuranceAsOptional)
        .map(OptInsurance::getName)
        .orElse("Unknown")
        ;

  }

  public static Set<String> getCarInsuranceNames(List<OptPerson> persons) {
    // Stream 으로 조작
    return persons.stream()
        .map(OptPerson::getCarAsOptional)
        .map(optCar -> optCar.flatMap(OptCar::getInsuranceAsOptional))
        .map(optInsurance -> optInsurance.map(OptInsurance::getName))
        .flatMap(Optional::stream)
        .collect(toSet())
        ;
  }

  public static int readDuration(Properties props, String name) {
    // getOrDefault 가 있기는 하지만 예제니깐...
    return Optional.ofNullable(props.getProperty(name))
        .flatMap(OptMain::stringToInt)
        .filter(i -> i > 0)
        .orElse(0)
        ;
  }

  private static Optional<Integer> stringToInt(String s) {
    try {
      return Optional.of(Integer.parseInt(s));
    } catch (NumberFormatException e) {
      return Optional.empty();
    }
  }

}
