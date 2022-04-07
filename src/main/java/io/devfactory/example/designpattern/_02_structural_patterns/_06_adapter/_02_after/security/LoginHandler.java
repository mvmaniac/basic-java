package io.devfactory.example.designpattern._02_structural_patterns._06_adapter._02_after.security;

@SuppressWarnings("ClassCanBeRecord")
public class LoginHandler {

  private final UserDetailsService userDetailsService;

  public LoginHandler(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  public String login(String username, String password) {
    UserDetails userDetails = userDetailsService.loadUser(username);

    if (!userDetails.getPassword().equals(password)) {
      throw new IllegalArgumentException();
    }

    return userDetails.getUsername();
  }

}
