package Ch1_change;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    // 이제 Theater의 enter()는 단순히 TicketSeller에게 sellTo 메시지를 보내기만 하면 된다.
    // ticketSeller가 은행에서 매표를 하던 매표소에서 매표를 하던 Theater는 관심이 없다.
    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
