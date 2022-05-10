package io.devfactory.example.refactoring._17_message_chain._37_hide_delegate.before;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class Department {

  private final String chargeCode;

  private final Person manager;

  public Department(String chargeCode, Person manager) {
    this.chargeCode = chargeCode;
    this.manager = manager;
  }

  public String getChargeCode() {
    return chargeCode;
  }

  public Person getManager() {
    return manager;
  }

}
