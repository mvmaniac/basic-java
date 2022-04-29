package io.devfactory.example.refactoring._06_mutable_data._23_change_reference_to_value;

import java.util.Objects;

import static java.util.Objects.hash;

@SuppressWarnings({"ClassCanBeRecord", "squid:S6206"})
public class TelephoneNumber {

  private final String areaCode;

  private final String number;

  public TelephoneNumber(String areaCode, String number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public String areaCode() {
    return areaCode;
  }

  public String number() {
    return number;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof TelephoneNumber that)) return false;
    if (!Objects.equals(areaCode, that.areaCode)) return false;
    return Objects.equals(number, that.number);
  }

  @Override
  public int hashCode() {
    return hash(areaCode, number);
  }

}
