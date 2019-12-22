package Ch5;

import Ch2.Money;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {
    private double perent;

    public PercentDiscountMovie(String title, Duration runningTime,
                                Money fee, double percent,
                                DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.perent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(perent);      // 상위 클래스의 getFee() 구현 내용을 알아야함.
    }
}
