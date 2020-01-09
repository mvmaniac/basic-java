package io.devfactory.objects.ticket;

// 소극장
public class Theater {

    private TicketSeller ticketSeller;

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            // 관람객이 가방에 초대장이 있는 경우
            // 판매원이 매표소에서 티켓을 내줌
            final Ticket ticket = ticketSeller.getTicketOffice().getTicket();

            // 관람객이 티켓을 가방에 넣음
            audience.getBag().putTicket(ticket);

        } else {
            // 관람객이 가방에 초대장이 없는 경우
            // 판매원이 매표소에서 티켓을 내줌
            final Ticket ticket = ticketSeller.getTicketOffice().getTicket();

            // 관람객 가방에 티켓 가격만큼 현금이 차감
            audience.getBag().minusAmount(ticket.getFee());

            // 판매원의 매표소에 티켓 가격만큼 판매금액이 증가
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());

            // 관람객이 티켓을 가방에 넣음
            audience.getBag().putTicket(ticket);
        }
    }

}
