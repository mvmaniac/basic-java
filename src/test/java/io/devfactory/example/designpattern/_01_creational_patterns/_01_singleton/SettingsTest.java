package io.devfactory.example.designpattern._01_creational_patterns._01_singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SettingsTest {
  
  @DisplayName("싱글톤 패턴 테스트")
  @Test
  void testSingleton() {
    assertThat(Settings.getInstance()).isSameAs(Settings.getInstance());
  }

}
