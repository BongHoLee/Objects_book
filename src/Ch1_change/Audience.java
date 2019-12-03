package Ch1_change;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    // 이제 bag의 인터페이스(hold) 에만 의존하게 되었다.
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }

}
