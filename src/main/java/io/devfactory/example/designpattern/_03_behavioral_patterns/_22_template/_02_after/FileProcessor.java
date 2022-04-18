package io.devfactory.example.designpattern._03_behavioral_patterns._22_template._02_after;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileProcessor {

  private final String path;

  protected FileProcessor(String path) {
    this.path = "P:\\YHS\\Dev\\Workspace_IntelliJ\\YHS_Study\\basic-java\\src\\main\\resources\\" + path;
  }

  public final int process() {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      int result = 0;
      String line;

      while ((line = reader.readLine()) != null) {
        result = getResult(result, Integer.parseInt(line));
      }

      return result;
    } catch (IOException e) {
      throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.", e);
    }
  }

  protected abstract int getResult(int result, int number);

}
