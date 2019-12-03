package Ch2;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    // 인자로 넘어온 screening이 사용되지 않는다.
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
