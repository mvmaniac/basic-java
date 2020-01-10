package io.devfactory.completable;

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

import static io.devfactory.util.CommonUtils.millisToSeconds;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

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

    private void executeFindShopPrices(Function<String, List<String>> findShopPrices, String product) {
        stopWatch.start();

        log.debug("[dev] {} - begin", product);
        log.debug("[dev] findShopPrices: {}", findShopPrices.apply(product));

        stopWatch.stop();

        final long lastTaskTimeMillis = stopWatch.getLastTaskTimeMillis();
        log.debug("[dev] {} - Done in: {} ms / {} sec", product, lastTaskTimeMillis, millisToSeconds(lastTaskTimeMillis));
    }

    static class ShopConvert extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            return new DepartmentStore(Integer.parseInt(String.valueOf(source)));
        }
    }

}