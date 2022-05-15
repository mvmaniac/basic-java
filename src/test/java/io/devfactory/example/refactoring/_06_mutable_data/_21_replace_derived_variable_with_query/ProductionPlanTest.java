package io.devfactory.example.refactoring._06_mutable_data._21_replace_derived_variable_with_query;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductionPlanTest {

  @Test
  void production() {
    ProductionPlan productionPlan = new ProductionPlan();
    productionPlan.applyAdjustment(10);
    productionPlan.applyAdjustment(20);
    assertThat(productionPlan.getProduction()).isEqualTo(30);
  }

}
