package io.devfactory.example.refactoring._16_temporary_field._36_introduce_special_case.before;

@SuppressWarnings("ClassCanBeRecord")
public class PaymentHistory {

  private final int weeksDelinquentInLastYear;

  public PaymentHistory(int weeksDelinquentInLastYear) {
    this.weeksDelinquentInLastYear = weeksDelinquentInLastYear;
  }

  public int getWeeksDelinquentInLastYear() {
    return this.weeksDelinquentInLastYear;
  }

}
