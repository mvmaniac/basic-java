package io.devfactory.example.refactoring._18_middle_man._40_replace_subclass_with_delegate;

public class PremiumDelegate {

  private final Booking host;
  private final PremiumExtra extra;

  public PremiumDelegate(Booking host, PremiumExtra extra) {
    this.host = host;
    this.extra = extra;
  }

  public boolean hasTalkback() {
    return this.host.show.hasOwnProperty("talkback");
  }

  public double extendBasePrice(double result) {
    return Math.round(result + this.extra.getPremiumFee());
  }

  public boolean hasDinner() {
    return this.extra.hasOwnProperty("dinner") && !this.host.isPeakDay();
  }

}
