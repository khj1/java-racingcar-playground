package study.racingcar;

import javax.swing.text.Position;
import java.util.Objects;

public class Car {
    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void move(MoveStrategy strategy) {
        if (strategy.movable()) {
            position.move();
        }
    }

    public boolean isSamePosition(int maxPosition) {
        return position.isSame(maxPosition);
    }


    public int getPositionValue() {
        return position.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
