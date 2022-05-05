package io.devfactory.example.refactoring._10_data_clumps.before;

public class Office {

  private final String location;

  private String officeAreCode;

  private String officeNumber;

  public Office(String location, String officeAreCode, String officeNumber) {
    this.location = location;
    this.officeAreCode = officeAreCode;
    this.officeNumber = officeNumber;
  }

  public String officePhoneNumber() {
    return this.officeAreCode + "-" + this.officeNumber;
  }

  public String getOfficeAreCode() {
    return this.officeAreCode;
  }

  public void setOfficeAreCode(String officeAreCode) {
    this.officeAreCode = officeAreCode;
  }

  public String getOfficeNumber() {
    return officeNumber;
  }

  public void setOfficeNumber(String officeNumber) {
    this.officeNumber = officeNumber;
  }

}
