package Ch5;

import Ch2.Customer;
import Ch2.Money;

import java.time.LocalDateTime;

// 예매에 대한 정보 전문가인 동시에 Reservation의 창조자.
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;


    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public Money calculateFee(int audienceCount) {

        // Movie에 전송하는 메시지의 시그니처를 보면 메시지 송신자인 Screening의 의도를 표현함을 알 수 있음
        // 즉, 메시지 송신자(클라이언트)의 의도를 표현하는 메시지가 협력의 문맥에서 의미있는 책임임 (메시지 수신자 x)
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return getWhenScreened();
    }

}
