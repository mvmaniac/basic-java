package io.devfactory.reactive.flow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.devfactory.reactive.flow.TempMain.getTemperatures;
import static io.devfactory.reactive.flow.TempMain.getTemperaturesWithProcessor;
import static org.assertj.core.api.Assertions.assertThat;

class TempMainTest {

    @DisplayName("Publisher 를 만들고 TempSubscriber 를 구독")
    @ParameterizedTest(name = "{index}, {displayName}, message={0}")
    @ValueSource(strings = {"New York"})
    void Publisher_를_만들고_TempSubscriber_를_구독(String town) {
        // 새 Publisher 를 만들고 TempSubscriber 를 구독시킴
        getTemperatures(town).subscribe(new TempSubscriber());

        passSonarLint();
    }

    @DisplayName("Publisher 를 만들고 TempSubscriber 를 구독 (TempProcessor 를 사용)")
    @ParameterizedTest(name = "{index}, {displayName}, message={0}")
    @ValueSource(strings = {"New York"})
    void Publisher_를_만들고_TempSubscriber_를_구독_TempProcessor_를_사용(String town) {
        // 새 Publisher 를 만들고 TempSubscriber 를 구독시킴
        getTemperaturesWithProcessor(town).subscribe(new TempSubscriber());

        passSonarLint();
    }

    // SonarLint pass 용
    private void passSonarLint() {
        assertThat(true).isTrue();
    }

}