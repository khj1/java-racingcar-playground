package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름은 쉼표를 기준으로 구분한다.")
    void carsDivide() {
        Cars carsA = new Cars("carA,carB");

        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Cars carsB = new Cars(Arrays.asList(carA, carB));

        assertThat(carsA).isEqualTo(carsB);
    }
}
