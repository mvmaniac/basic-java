package io.devfactory.example.refactoring._06_mutable_data._18_split_variable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleTest {

  @Test
  void updateGeometry() {
    Rectangle rectangle = new Rectangle();

    rectangle.updateGeometry(10, 5);
    assertThat(rectangle.getArea()).isEqualTo(50d);
    assertThat(rectangle.getPerimeter()).isEqualTo(30d);

    rectangle.updateGeometry(5, 5);
    assertThat(rectangle.getArea()).isEqualTo(25d);
    assertThat(rectangle.getPerimeter()).isEqualTo(20d);
  }

}
