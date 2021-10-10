package study;

import study.racingcar.RacingCar;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        RacingCar racingCar = new RacingCar();
        racingCar.start();
    }
}
