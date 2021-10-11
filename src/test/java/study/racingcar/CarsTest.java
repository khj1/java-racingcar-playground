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

    @Test
    @DisplayName("우승자는 한명 이상일 수 있다.")
    void findWinner() {
        Car carA = new Car("carA", 1);
        Car carB = new Car("carB", 0);
        Car carC = new Car("carC", 1);

        Cars cars = new Cars(Arrays.asList(carA, carB, carC));

        assertThat(cars.findWinner()).extracting("name").containsExactly(new CarName("carA"), new CarName("carC"));
    }

}
