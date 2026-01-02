package lotto.util;

import static lotto.constant.ErrorMessage.DEFAULT_MESSAGE;

public class Validator {
    public static void validateMultipleOfThousand(int inputValue) {
        if (inputValue % 1000 != 0) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE.getErrorMessage());
        }
    }
}
