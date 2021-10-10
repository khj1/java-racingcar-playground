package study.racingcar;

import java.io.IOException;

public class RacingCar {

    private final Cars cars;
    private final Integer gameCounts;

    public RacingCar() throws IOException {
        this.cars = new Cars(InputView.inputNames());
        this.gameCounts = InputView.inputTimes();
    }

    public void start() {
        ResultView.printInit();

        for (int i = 0; i < gameCounts; i++) {
            cars.play(cars.getCars());
            ResultView.printResults(cars);
        }

        ResultView.printWinners(cars.getWinners(gameCounts));
    }
}
