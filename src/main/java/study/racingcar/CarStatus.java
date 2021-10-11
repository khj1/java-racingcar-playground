package study.racingcar;

import java.util.Random;

public enum CarStatus {
    MOVE, STOP;

    public static CarStatus getRandomValue() {
        Random random = new Random();
        return values()[random.nextInt(1)];
    }

    public boolean isMove() {
        return this == MOVE;
    }
}
