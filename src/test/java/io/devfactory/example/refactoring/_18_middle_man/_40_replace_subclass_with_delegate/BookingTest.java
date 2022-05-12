package io.devfactory.example.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookingTest {

  @Test
  void basePrice() {
    Show lionKing = new Show(List.of(), 120);
    LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);

    Booking booking = Booking.createBooking(lionKing, weekday);
    assertThat(booking.basePrice()).isEqualTo(120);

    Booking premium = Booking.createPremiumBooking(lionKing, weekday, new PremiumExtra(List.of(), 50));
    assertThat(premium.basePrice()).isEqualTo(170);
  }

  @Test
  void basePrice_on_peakDay() {
    Show lionKing = new Show(List.of(), 120);
    LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

    Booking booking = Booking.createBooking(lionKing, weekend);
    assertThat(booking.basePrice()).isEqualTo(138);

    Booking premium = Booking.createPremiumBooking(lionKing, weekend, new PremiumExtra(List.of(), 50));
    assertThat(premium.basePrice()).isEqualTo(188);
  }

  @Test
  void talkback() {
    Show noTalkbackShow = new Show(List.of(), 120);
    Show talkbackShow = new Show(List.of("talkback"), 120);
    LocalDateTime nonPeekDay = LocalDateTime.of(2022, 1, 20, 19, 0);
    LocalDateTime peekDay = LocalDateTime.of(2022, 1, 15, 19, 0);

    assertThat(Booking.createBooking(noTalkbackShow, nonPeekDay).hasTalkback()).isFalse();
    assertThat(Booking.createBooking(talkbackShow, nonPeekDay).hasTalkback()).isTrue();
    assertThat(Booking.createBooking(talkbackShow, peekDay).hasTalkback()).isFalse();

    PremiumExtra premiumExtra = new PremiumExtra(List.of(), 50);
    assertThat(Booking.createPremiumBooking(talkbackShow, peekDay, premiumExtra).hasTalkback()).isTrue();
    assertThat(Booking.createPremiumBooking(noTalkbackShow, peekDay, premiumExtra).hasTalkback()).isFalse();
  }

  @Test
  void hasDinner() {
    Show lionKing = new Show(List.of(), 120);
    LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
    LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);
    PremiumExtra premiumExtra = new PremiumExtra(List.of("dinner"), 50);

    assertThat(Booking.createBooking(lionKing, weekday).hasDinner()).isFalse();
    assertThat(Booking.createBooking(lionKing, weekend).hasDinner()).isFalse();
    
    assertThat(Booking.createPremiumBooking(lionKing, weekday, premiumExtra).hasDinner()).isTrue();
    assertThat(Booking.createPremiumBooking(lionKing, weekend, premiumExtra).hasDinner()).isFalse();
  }

}
