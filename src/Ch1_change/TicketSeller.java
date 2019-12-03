package Ch1_change;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    //TicketOffice의 인터페이스에만 의존하게 되었다.
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);

    }

}
