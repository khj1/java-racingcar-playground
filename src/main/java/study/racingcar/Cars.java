package study.racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String namesWithComma) {
        if (validation(namesWithComma)) {
            this.cars = addCars(namesWithComma.split(","));
        }
    }

    private boolean validation(String namesWithComma) {
        if (namesWithComma.contains(",")) {
            return true;
        }
        throw new IllegalArgumentException("자동차는 2대 이상이어야 하며 ,로 구분되어야합니다.");
    }

    // 테스트용
    Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> addCars(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play(List<Car> cars) {
        cars.forEach(car -> car.race(CarStatus.getRandomStatus()));
    }

    public Winners getWinners(int gameCounts) {
        Winners winners = new Winners();
        Integer maxPosition = getMaxPosition();

        cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .forEach(winners::addWinner);

        return winners;
    }

    private Integer getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
