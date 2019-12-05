package Ch4_2;


import Ch2.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

// 데이터 중심 설계
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;


    // getter로 이 객체의 속성 정보를 인터페이스에 노출
    public MovieType getMovieType() {
        return movieType;
    }


    // calculateAmountDiscountedFee() 메서드는 인터페이스로 금액 할인 정책이 존재함을 노출
    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    // calculatePercentDiscountedFee() 메서드는 인터페이스로 비율 할인 정책이 존재함을 노출
    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    // calculateNoneDiscountedFee() 메서드는 인터페이스로 미적용 할인 정책이 존재함을 노출
    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreend, int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if(condition.isDiscountable(whenScreend.getDayOfWeek(), whenScreend.toLocalTime())) {
                    return true;
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }

        return false;
    }


}
