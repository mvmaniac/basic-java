package io.devfactory.example.refactoring._11_primitive_obsession._30_repliace_primitive_with_object.before;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class Order {

  private final String priority;

  public Order(String priority) {
    this.priority = priority;
  }

  public String getPriority() {
    return priority;
  }

}
