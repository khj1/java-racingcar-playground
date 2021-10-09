package study.racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String namesWithComma) {
        this.cars = addCars(namesWithComma.split(","));
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
        return this.cars;
    }

    public void play(List<Car> cars) {
        cars.forEach(car -> car.race(CarStatus.getRandomStatus()));
    }

    public Winners getWinners(int gameCounts) {
        Winners winners = new Winners();
        cars.stream()
                .filter(car -> car.isWinner(gameCounts))
                .forEach(winners::addWinner);

        return winners;
    }
}
