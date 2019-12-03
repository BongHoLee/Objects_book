package Ch2;

import java.time.LocalDateTime;

// 예매자들이 예매하는 대상인 '상영'을 구현하는 클래스

// 상영할 영화(move), 순번(sequence), 상영 시작 시간(whenScreend)를 인스턴스 변수로 포함
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreend;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreend) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreend = whenScreend;
    }

    public LocalDateTime getStartTime() {
        return whenScreend;
    }

    // 순번 일치 여부를 반환
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    //
    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
