package io.devfactory.example.refactoring._07_divergent_change._24_split_phase.before;

import io.devfactory.example.refactoring._07_divergent_change._24_split_phase.Product;
import io.devfactory.example.refactoring._07_divergent_change._24_split_phase.ShippingMethod;

public class PriceOrder {

  public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
    final double basePrice = product.basePrice() * quantity;
    final double discount = Math.max(quantity - product.discountThreshold(), 0)
        * product.basePrice() * product.discountRate();
    final double shippingPerCase = (basePrice > shippingMethod.discountThreshold()) ?
        shippingMethod.discountedFee() : shippingMethod.feePerCase();
    final double shippingCost = quantity * shippingPerCase;
    return basePrice - discount + shippingCost;
  }

}
