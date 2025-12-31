package lotto.util;

import static lotto.constant.ErrorMessage.MULTIPLES_OF_1000_ERROR;
import static lotto.constant.ErrorMessage.NULL_OR_EMPTY_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_NOT_6_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_RANGE_ERROR;

import java.util.List;

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

    public static void validateNumberRange(List<Integer> intWinningNumber) {
        for (Integer number : intWinningNumber) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getErrorMessage());
            }
        }
    }

    public static void validateNotDuplicate(List<Integer> intWinningNumber) {
        //distinct = 중복제거, count = 사이즈
        if (intWinningNumber.size() != intWinningNumber.stream().distinct().count()) {
            throw new IllegalArgumentException(NUMBER_NOT_6_ERROR.getErrorMessage());
        }
    }
}
