package io.devfactory.example.refactoring._11_primitive_obsession._30_repliace_primitive_with_object.before;

import java.util.List;

public class OrderProcessor {

  public long numberOfHighPriorityOrders(List<Order> orders) {
    return orders.stream()
        .filter(o -> "high".equals(o.getPriority()) || "rush".equals(o.getPriority()))
        .count();
  }

}
