package study.racingcar;

import java.util.Random;

public enum CarStatus {
    MOVE, STOP;

    public boolean isMove() {
        return this == MOVE;
    }

    public static CarStatus getRandomStatus() {
        Random rnd = new Random();
        return values()[rnd.nextInt(values().length)];
    }
}
