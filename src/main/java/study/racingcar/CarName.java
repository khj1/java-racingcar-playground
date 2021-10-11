package study.racingcar;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
