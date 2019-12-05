package Ch4_2;


import java.time.DayOfWeek;
import java.time.LocalTime;

// 할인 조건을 구현
public class DiscountCondition {
    private DiscountConditionType type;

    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    // getType 메서드를 통해 내부에 DiscountConditionType을 포함하고 있다는 정보가 노출된다.
    public DiscountConditionType getType() {
        return type;
    }

    // 기간 조건일 때 판단
    // 메서드의 파라미터 (DayOfWeek, LocalTime)으로 이 객체의 내부 속성으로 요일정보와 시간정보가 인스턴스 변수로 포함됨을 노출
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }

        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;
    }

    // 순번 조건일 때 판단.
    // 메서드의 파라미터 int sequence으로 이 객체의 내부 속성에 순서 정보가 인스턴스 변수로 포함됨을 노출
    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException();
        }

        return this.sequence == sequence;
    }


}
