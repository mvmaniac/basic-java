package io.devfactory.example.modernjava.functional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.devfactory.example.modernjava.functional.Subset.subsets;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;

@SuppressWarnings("squid:S1186")
@Slf4j
class SubsetTest {

  @DisplayName("서브셋_테스트")
  @Test
  void 서브셋_테스트() {
    final String subsets = subsets(List.of(1, 4, 9)).stream()
        .sorted(comparingInt(List::size))
        .map(Object::toString)
        .collect(joining(", "));

    log.debug("[dev] subsets: {}", subsets);
  }

}
