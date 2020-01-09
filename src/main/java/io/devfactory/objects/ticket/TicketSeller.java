package io.devfactory.objects.ticket;

// 판매원
public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        // 판매원 매표소의 티켓을 관람객에게 주고
        // 관람객이 준 현금만큼 판매금액이 증가
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }

}
