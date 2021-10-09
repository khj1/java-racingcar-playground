package study.racingcar;

public class CarName {

    private String name;

    public CarName(String name) {
        if (validation(name)) {
            this.name = name;
        }
    }

    private boolean validation(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
