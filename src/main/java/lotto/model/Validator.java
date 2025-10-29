package lotto.model;

import static lotto.constant.ErrorMessage.*;

public class Validator {
    public static void validateNotBlank(String inputValue) {
        if (inputValue == "" || inputValue == " "){
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR.getErrorMessage());
        }
    }

    public static void validateNumericAmount(int inputValue) {
        if (inputValue % 1000 == 0){
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_1000_ERROR.getErrorMessage());
        }
    }
}
