package study.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    void setCarName() {
        Car car = new Car("carA");
        assertThat(car.getName()).isEqualTo("carA");
    }
}
