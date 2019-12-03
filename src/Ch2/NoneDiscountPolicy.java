package Ch2;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calcuateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
