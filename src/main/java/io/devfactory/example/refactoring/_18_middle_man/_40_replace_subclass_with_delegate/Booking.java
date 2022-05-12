package io.devfactory.example.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static java.util.Objects.nonNull;

public class Booking {

  protected Show show;

  protected LocalDateTime time;

  protected PremiumDelegate premiumDelegate;

  public Booking(Show show, LocalDateTime time) {
    this.show = show;
    this.time = time;
  }

  public static Booking createBooking(Show show, LocalDateTime time) {
    return new Booking(show, time);
  }

  public static Booking createPremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
    Booking booking = createBooking(show, time);
    booking.premiumDelegate = new PremiumDelegate(booking, extra);
    return booking;
  }

  public boolean hasTalkback() {
    return nonNull(this.premiumDelegate) ? this.premiumDelegate.hasTalkback() :
        this.show.hasOwnProperty("talkback") && !this.isPeakDay();
  }

  protected boolean isPeakDay() {
    DayOfWeek dayOfWeek = this.time.getDayOfWeek();
    return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
  }

  public double basePrice() {
    double result = this.show.getPrice();
    if (this.isPeakDay()) result += Math.round(result * 0.15);
    return nonNull(this.premiumDelegate) ? this.premiumDelegate.extendBasePrice(result) : result;
  }

  public boolean hasDinner() {
    return nonNull(this.premiumDelegate) && this.premiumDelegate.hasDinner();
  }

}
