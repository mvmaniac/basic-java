package io.devfactory.stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("squid:S2699")
@Slf4j
class TransactionTest {

  private static List<Transaction> transactions;

  private Consumer<Object> logDev = o -> log.debug("[dev] {}", o);

  @BeforeAll
  static void setUp() {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );
  }

  @DisplayName("연도가 2011년에 일어난 모든 거래를 찾아 값을 오름차순으로 정렬 할 수 있다")
  @Test
  void 연도가_2011년에_일어난_모든_거래를_찾아_값을_오름차순으로_정렬_할_수_있다() {
    transactions.stream()
        .filter(t -> t.getYear() == 2011)
        .sorted(comparingInt(Transaction::getValue))
        .collect(toList())
        .forEach(logDev)
    ;
  }

  @DisplayName("거래자가 근무하는 모든 도시를 중복없이 반환 할 수 있다")
  @Test
  void 거래자가_근무하는_모든_도시를_중복없이_반환_할_수_있다() {
    transactions.stream()
        .map(t -> t.getTrader().getCity())
        .distinct()
        .collect(toList())
        .forEach(logDev)
    ;
  }

  @DisplayName("Cambridge 에서 근무하는 모든 거래자를 찾아 이름순으로 정렬 할 수 있다")
  @Test
  void Cambridge_에서_근무하는_모든_거래자를_찾아_이름순으로_정렬_할_수_있다() {
    // trader 로 반환
    transactions.stream()
        .map(Transaction::getTrader)
        .filter(t -> "Cambridge".equals(t.getCity()))
        .distinct()
        .sorted(comparing(Trader::getName))
        .collect(toList())
        .forEach(logDev)
    ;

    log.debug("[dev] ---------------------------------------------------");

    // transaction 로 반환 (중복제거 안됨...)
    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .sorted(comparing(Transaction::getTrader, comparing(Trader::getName)))
        .collect(toList())
        .forEach(logDev)
    ;
  }

  @DisplayName("알파벳 순으로 정렬된 모든 거래자의 이름 문자열을 반환 할 수 있다")
  @Test
  void 알파벳_순으로_정렬된_모든_거래자의_이름_문자열을_반환_할_수_있다() {
    String namesByReduce = transactions.stream()
        .map(t -> t.getTrader().getName())
        .distinct()
        .sorted()
        .reduce("", (n1, n2) -> n1 + " " + n2);

    log.debug("[dev] namesByReduce: {}", namesByReduce);

    String namesByJoining = transactions.stream()
        .map(t -> t.getTrader().getName())
        .distinct()
        .sorted()
        .collect(joining(", "));

    log.debug("[dev] namesByJoining: {}", namesByJoining);
  }

  @DisplayName("Milan 에 거주하는 거래자가 있는지 확인 할 수 있다")
  @Test
  void Milan_에_거주하는_거래자가_있는지_확인_할_수_있다() {
    final boolean isExist = transactions.stream()
        .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));

    log.debug("[dev] isExist Milan: {}", isExist);
  }

  @DisplayName("Cambridge 에 사는 거래자의 모든 트랜잭션 값을 반환 할 수 있다")
  @Test
  void Cambridge_에_사는_거래자의_모든_트랜잭션_값을_반환_할_수_있다() {
    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(Transaction::getValue)
        .collect(toList())
        .forEach(logDev)
    ;
  }

  @DisplayName("모든 거래에서 최고값과 최소값을 반환 할 수 있다")
  @Test
  void 모든_거래에서_최고값과_최소값을_반환_할_수_있다() {
    final Optional<Integer> maxValueByReduce = transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::max);

    log.debug("[dev] maxValueByReduce: {}", maxValueByReduce.orElse(0));

    final Optional<Integer> maxValueByMax = transactions.stream()
        .map(Transaction::getValue)
        .max(Integer::compareTo);

    log.debug("[dev] maxValueByMax: {}", maxValueByMax.orElse(null));

    final OptionalInt maxValueByPrimitive = transactions.stream()
        .mapToInt(Transaction::getValue)
        .max();

    log.debug("[dev] maxValueByPrimitive: {}", maxValueByPrimitive.orElse(0));
  }

}
