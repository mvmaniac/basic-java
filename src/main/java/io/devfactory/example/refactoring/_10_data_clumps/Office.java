package io.devfactory.example.refactoring._10_data_clumps;

public class Office {

  private final TelephoneNumber officeTelephoneNumber;

  public Office(TelephoneNumber officeTelephoneNumber) {
    this.officeTelephoneNumber = officeTelephoneNumber;
  }

  public String officePhoneNumber() {
    return this.officeTelephoneNumber.toString();
  }

  public String getOfficeAreCode() {
    return this.officeTelephoneNumber.getAreaCode();
  }

  public void setOfficeAreCode(String officeAreCode) {
    this.officeTelephoneNumber.setAreaCode(officeAreCode);
  }

  public String getOfficeNumber() {
    return this.officeTelephoneNumber.getNumber();
  }

  public void setOfficeNumber(String officeNumber) {
    this.officeTelephoneNumber.setNumber(officeNumber);
  }

}
