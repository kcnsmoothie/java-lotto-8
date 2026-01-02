package lotto.util;

import static lotto.constant.ErrorMessage.DEFAULT_MESSAGE;

import java.util.List;

public class Validator {
    public static void validateMultipleOfThousand(int inputValue) {
        if (inputValue % 1000 != 0) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE.getErrorMessage());
        }
    }

    public static void validateNotDuplicate(List<Integer> intWinningNumber) {
        if (intWinningNumber.size() != intWinningNumber.stream().distinct().count()) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE.getErrorMessage());
        }
    }

    public static void validateInRange(int inputValue) {
        if (inputValue < 1 || 45 < inputValue) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE.getErrorMessage());
        }
    }

    public static void validateSize(List<Integer> inputValue) {
        if (inputValue.size() != 6) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE.getErrorMessage());
        }
    }
}
