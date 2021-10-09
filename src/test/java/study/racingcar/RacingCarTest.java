package study.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    void 자동차_이름_부여() {
        Car car = new Car("carA");
        assertThat(car.getName()).isEqualTo("carA");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void 자동차_이름_5자_초과() {
        assertThatThrownBy(() -> new Car("666666"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 쉼표를 기준으로 구분한다.")
    void 자동차_이름_쉼표_구분() {
        Cars cars = new Cars("carA,carB,carC");
        List<Car> carList = cars.getCars();
        assertThat(carList).extracting("name")
                .containsExactly("carA", "carB", "carC");
    }
}
