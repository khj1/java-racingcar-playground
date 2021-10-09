package study.racingcar;

public class Car {
    private final CarName name;
    private Integer position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name.toString();
    }

    public void race(CarStatus status) {
        if (status.isMove()) {
            this.position ++;
        }
    }

    public boolean isWinner(int gameCounts) {
        return position == gameCounts;
    }
}
