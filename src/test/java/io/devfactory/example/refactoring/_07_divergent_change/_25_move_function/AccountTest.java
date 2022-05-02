package io.devfactory.example.refactoring._07_divergent_change._25_move_function;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

  @Test
  void bankCharge() {
    Account account = new Account(5, new AccountType(true));
    assertThat(account.getBankCharge()).isEqualTo(14.5);

    account = new Account(8, new AccountType(true));
    assertThat(account.getBankCharge()).isEqualTo(15.35);

    account = new Account(8, new AccountType(false));
    assertThat(account.getBankCharge()).isEqualTo(18.5);
  }

}
