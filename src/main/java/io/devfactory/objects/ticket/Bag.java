package io.devfactory.objects.ticket;

import java.util.Objects;

// 소지품을 보관하는 가방
// 초대장, 티켓, 현금을 보유 할 수 있음
public class Bag {

    private long amount; // 현금
    private Invitation invitation; // 초대장
    private Ticket ticket; // 티켓
    
    public Bag(long amount) {
        this(null, amount);
    }
    
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public void putTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean hasInvitation() {
        return Objects.nonNull(invitation);
    }

    public boolean hasTicket() {
        return Objects.nonNull(ticket);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }

}
