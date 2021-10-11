package study.racingcar;

public class RandomMoveStrategy implements MoveStrategy{
    @Override
    public boolean movable() {
        CarStatus status = CarStatus.getRandomValue();
        return status.isMove();
    }
}
