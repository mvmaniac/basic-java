package io.devfactory.objects.ticket;

// 관람객
public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            // 관람객이 가방에 초대장이 있는 경우
            // 관람객이 티켓을 가방에 넣음
            bag.putTicket(ticket);

            // 초대장이 있기 떄문에 가격 0
            return 0L;

        } else {
            // 관람객이 가방에 초대장이 없는 경우
            // 관람객이 티켓을 가방에 넣음
            bag.putTicket(ticket);

            // 관람객 가방에 티켓 가격만큼 현금이 차감
            bag.minusAmount(ticket.getFee());

            // 티켓 가격
            return ticket.getFee();
        }
    }

}
