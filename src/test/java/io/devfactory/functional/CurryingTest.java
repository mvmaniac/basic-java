package io.devfactory.functional;

import static io.devfactory.functional.Currying.curriedConverter;

import java.util.function.DoubleUnaryOperator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("squid:S2699")
@Slf4j
class CurryingTest {

  @DisplayName("커링_테스트")
  @Test
  void 커링_테스트() {
    final DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
    final DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
    final DoubleUnaryOperator convertKMtoMI = curriedConverter(0.6214, 0);

    log.debug("[dev] convertUSDtoGBP(100): {}", convertUSDtoGBP.applyAsDouble(100));
  }

}
