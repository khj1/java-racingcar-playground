package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners = new ArrayList<>();

    public void addWinner(Car car) {
        winners.add(car);
    }

    public List<Car> getWinners() {
        return winners;
    }
}
