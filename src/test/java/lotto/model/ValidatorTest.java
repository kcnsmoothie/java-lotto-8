package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null 또는 공백인지 검사")
    void tryCountsIsNegative(String inputValue) {
        assertThatThrownBy(() -> Validator.validateNotBlank(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
