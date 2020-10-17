package io.devfactory.objects.ticket;

// 관람객
public class Audience {

  private Bag bag;

  public Audience(Bag bag) {
    this.bag = bag;
  }

  public long buy(Ticket ticket) {
    return bag.hold(ticket);
  }

}
