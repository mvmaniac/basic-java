package io.devfactory.example.designpattern._03_behavioral_patterns._22_template._01_before;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class FileProcessorTest {
  
  @DisplayName("변경 전 템플릿 메소드 패턴")
  @Test
  void testTemplate() {
    FileProcessor fileProcessor = new FileProcessor("number.txt");
    int result = fileProcessor.process();
    log.debug("{}", result);
  }

}
