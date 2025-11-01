package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null 또는 공백인지 검사")
    void validateNotBlank_test(String inputValue) {
        assertThatThrownBy(() -> Validator.validateNotBlank(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위로 나누어 떨어지는지 검사 - 실패")
    void validateNotMultipleOfThousand_test() {
        //given
        int inputValue = 1249;

        //when & then
        assertThatThrownBy(() -> Validator.validateNotMultipleOfThousand(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
