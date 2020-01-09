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
    
    public long hold(Ticket ticket) {
        if (hasInvitation()) {
            // 관람객이 가방에 초대장이 있는 경우
            // 관람객이 티켓을 가방에 넣음
            putTicket(ticket);

            // 초대장이 있기 떄문에 가격 0
            return 0L;

        } else {
            // 관람객이 가방에 초대장이 없는 경우
            // 관람객이 티켓을 가방에 넣음
            putTicket(ticket);

            // 관람객 가방에 티켓 가격만큼 현금이 차감
            minusAmount(ticket.getFee());

            // 티켓 가격
            return ticket.getFee();
        }
    }

    private void putTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private boolean hasInvitation() {
        return Objects.nonNull(invitation);
    }

    private boolean hasTicket() {
        return Objects.nonNull(ticket);
    }

    private void minusAmount(long amount) {
        this.amount -= amount;
    }

    private void plusAmount(long amount) {
        this.amount += amount;
    }

}
