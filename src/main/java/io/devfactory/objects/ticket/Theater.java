package io.devfactory.objects.ticket;

// 소극장
public class Theater {

    private TicketSeller ticketSeller;

    public void enter(Audience audience) {
        // 판매원이 관람객에게 티켓을 판매함
        ticketSeller.sellTo(audience);
    }

}
