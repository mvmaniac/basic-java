package io.devfactory.example.objects.movie;

import io.devfactory.example.objects.money.Money;

// 예약
public class Reservation {

  private Customer customer; // 고객
  private Screening screening;  // 상영 정보
  private Money money; // 예매 요금
  private int audienceCount; // 인원 수

  public Reservation(Customer customer, Screening screening, Money money, int audienceCount) {
    this.customer = customer;
    this.screening = screening;
    this.money = money;
    this.audienceCount = audienceCount;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Screening getScreening() {
    return screening;
  }

  public Money getMoney() {
    return money;
  }

  public int getAudienceCount() {
    return audienceCount;
  }

}
