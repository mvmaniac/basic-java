package io.devfactory.example.designpattern._03_behavioral_patterns._14_command._01_before;

@SuppressWarnings("ClassCanBeRecord")
public class Button {

  private final Light light;

  public Button(Light light) {
    this.light = light;
  }

  public void press() {
    light.off();
  }

}
