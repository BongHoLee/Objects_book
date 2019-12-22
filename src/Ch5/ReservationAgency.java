package Ch5;

import Ch2.Customer;
import Ch2.Money;

// 데이터 클래스들을 조합하여 영화 예매 절차를 구현하는 클래스
public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
       boolean discountable
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream().anyMatch(condition -> isDiscountable())
    }
}
