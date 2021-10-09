package study.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야한다.")
    void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_숫자하나() {
        int result = StringCalculator.splitAndSum("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 컴마로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum_숫자두개_컴마() {
        int result = StringCalculator.splitAndSum("1,4");
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("구분자는 컴마 이외에 콜론을 사용할 수 있다.")
    void splitAndSum_컴마_콜론() {
        int result = StringCalculator.splitAndSum("1,4:5");
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("'//'와 '\\n' 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void splitAndSum_커스텀_구분자() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void splitAndSum_음수전달() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
