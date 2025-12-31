package lotto.util;

import static lotto.constant.ErrorMessage.MULTIPLES_OF_1000_ERROR;
import static lotto.constant.ErrorMessage.NULL_OR_EMPTY_ERROR;

public class Validator {
    public static void validateNotBlank(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR.getErrorMessage());
        }
    }

    public static void validateMutiplesOf1000(int intValue) {
        if (intValue % 1000 != 0) {
            throw new IllegalArgumentException(MULTIPLES_OF_1000_ERROR.getErrorMessage());
        }
    }
}
