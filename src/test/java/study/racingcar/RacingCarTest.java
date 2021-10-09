package study.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    void setCarName() {
        Car car = new Car("carA");
        assertThat(car.getName()).isEqualTo("carA");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void carNameValidationTest() {
        assertThatThrownBy(() -> new Car("666666"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
