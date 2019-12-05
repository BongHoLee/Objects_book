package Ch4_2;

public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    // 자신의 데이터를 스스로 책임진다.
    public void enlarge(int multiple) {
        right *= multiple;
        bottom *= multiple;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}

// 외부 객체
class AnyClass {

    // ractangle 객체의 내부 구현에 강하게 결합된 예
    void anyMethod1(Rectangle ractangle, int multiple) {
        ractangle.setRight(ractangle.getRight() * multiple);
        ractangle.setLeft(ractangle.getLeft() * multiple);
    }

    // ractangle 객체의 인터페이스에만 결합
    void anyMethod2(Rectangle rectangle) {
        rectangle.enlarge(5);
    }
}
