package Ch4_2;

import Ch2.Customer;
import Ch2.Money;

// 데이터 클래스들을 조합하여 영화 예매 절차를 구현하는 클래스
public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;
        for(DiscountCondition condition : movie.getDiscountConditions()) {

            // 할인 조건 여부 확인
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreend().getDayOfWeek().equals(condition.getDayOfWeek())
                              && condition.getStartTime().compareTo(screening.getWhenScreend().toLocalTime()) <= 0
                              && condition.getEndTime().compareTo(screening.getWhenScreend().toLocalTime()) >=0;
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }

        }

        // 할인정책 적용 여부 확인 하여 요금 계산
        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }

            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
