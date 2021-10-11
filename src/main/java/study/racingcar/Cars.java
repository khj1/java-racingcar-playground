package study.racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String names) {
        this(extractCarList(names));
    }

    private static List<Car> extractCarList(String names) {
        String[] carsArray = names.split(",");
        return Arrays.stream(carsArray)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> findWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPositionValue)
                .max()
                .orElse(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
