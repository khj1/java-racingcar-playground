package study.racingcar;

public class Car {
    private final String name;
    private Integer position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void race(CarStatus status) {
        if (status.isMove()) {
            this.position ++;
        }
    }
}
