package io.devfactory.example.designpattern._02_structural_patterns._06_adapter._02_after;

import io.devfactory.example.designpattern._02_structural_patterns._06_adapter._02_after.security.LoginHandler;
import io.devfactory.example.designpattern._02_structural_patterns._06_adapter._02_after.security.UserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class AccountUserDetailsServiceTest {

  @DisplayName("변경 후 어댑터 패턴 테스트")
  @Test
  void testAdapter() {
    AccountService accountService = new AccountService();
    UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);

    LoginHandler loginHandler = new LoginHandler(userDetailsService);
    String login = loginHandler.login("dev", "1234");

    log.debug("{}", login);
  }

}
