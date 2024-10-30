package io.devfactory.example.modernjava.completable;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.function.Function;

import static io.devfactory.global.util.CommonUtils.millisToSeconds;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SuppressWarnings("squid:S1186")
@Slf4j
@TestInstance(PER_CLASS)
class DepartmentStoreTest {

  private StopWatch stopWatch;

  @BeforeAll
  void setUp() {
    stopWatch = new StopWatch("DepartmentStoreTest");
  }

  @DisplayName("findShopPricesXXX_테스트")
  @ParameterizedTest(name = "{index}, {displayName}, size={0}")
  @ValueSource(ints = {4, 8, 16, 18})
  void findShopPricesXXX_테스트(@ConvertWith(ShopConvert.class) DepartmentStore store) {
    executeFindShopPrices(store::findShopPricesBlocking, "findShopPricesBlocking");
    log.debug("[dev] ---------------------------------------------------");
    executeFindShopPrices(store::findShopPricesParallel, "findShopPricesParallel");
    log.debug("[dev] ---------------------------------------------------");
    executeFindShopPrices(store::findShopPricesSupplyAsync, "findShopPricesSupplyAsync");
    log.debug("[dev] ---------------------------------------------------");
    executeFindShopPrices(store::findShopPricesSupplyAsyncWithExecutor, "findShopPricesSupplyAsyncWithExecutor");
  }

  @DisplayName("findShopPricesWithDiscount_테스트")
  @ParameterizedTest(name = "{index}, {displayName}, size={0}")
  @ValueSource(ints = {5})
  void findShopPricesWithDiscount_테스트(@ConvertWith(ShopConvert.class) DepartmentStore store) {
    executeFindShopPrices(store::findShopPricesWithDiscount, "findShopPricesWithDiscount");
    log.debug("[dev] ---------------------------------------------------");
    executeFindShopPrices(store::findShopPricesWithDiscountSupplyAsync, "findShopPricesWithDiscountSupplyAsync");
  }

  @DisplayName("printShopPricesWithDiscount_테스트")
  @ParameterizedTest(name = "{index}, {displayName}, size={0}")
  @ValueSource(ints = {5})
  void printShopPricesWithDiscount_테스트(@ConvertWith(ShopConvert.class) DepartmentStore store) {
    store.printShopPricesWithDiscount("printShopPricesWithDiscount");
  }

  @DisplayName("findShopPricesWithExchangeSupplyAsync_테스트")
  @ParameterizedTest(name = "{index}, {displayName}, size={0}")
  @ValueSource(ints = {5})
  void findShopPricesWithExchangeSupplyAsync_테스트(
      @ConvertWith(ShopConvert.class) DepartmentStore store) {
    executeFindShopPrices(store::findShopPricesWithExchangeSupplyAsync, "findShopPricesWithExchangeSupplyAsync");
  }

  private void executeFindShopPrices(Function<String, List<String>> findShopPrices,
      String product) {
    stopWatch.start();

    log.debug("[dev] {} - begin", product);
    log.debug("[dev] findShopPrices: {}", findShopPrices.apply(product));

    stopWatch.stop();

    final long lastTaskTimeMillis = stopWatch.getLastTaskTimeMillis();
    log.debug("[dev] {} - Done in: {} ms / {} sec", product, lastTaskTimeMillis, millisToSeconds(lastTaskTimeMillis));
  }

  static class ShopConvert extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source,
        Class<?> targetType) throws ArgumentConversionException {
      return new DepartmentStore(Integer.parseInt(String.valueOf(source)));
    }

  }

}
