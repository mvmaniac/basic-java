package io.devfactory.example.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderProcessorTest {

  @Test
  void numberOfHighPriorityOrders() {
    OrderProcessor orderProcessor = new OrderProcessor();
    long highPriorityOrders = orderProcessor.numberOfHighPriorityOrders(
        List.of(new Order("low"),
            new Order("normal"),
            new Order("high"),
            new Order("rush")));

    assertThat(highPriorityOrders).isEqualTo(2);
  }

}
