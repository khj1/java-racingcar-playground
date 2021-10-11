package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    void carName() {
        Car car = new Car("carA");
        assertThat(car).isEqualTo(new Car("carA"));
    }

    @Test
    @DisplayName("자동차 이름은 1자 이상 5자 이하여야한다.")
    void carNameVaidation() {
        Car carA = new Car("a");
        Car carC = new Car("aaaaa"); //5

        assertThat(carA).isEqualTo(new Car("a"));
        assertThat(carC).isEqualTo(new Car("aaaaa"));

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 경주 시 매 시도마다 자동차는 한칸 전진하거나 가만히 멈춰있는다.")
    void moveOrStop() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");

        carA.move();

        assertThat(carA).isEqualTo(new Car("carA", 1));
        assertThat(carB).isEqualTo(new Car("carB", 0));
    }
}
