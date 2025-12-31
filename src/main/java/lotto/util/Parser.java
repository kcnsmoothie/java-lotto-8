package lotto.util;

import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;

public class Parser {
    public static int parseStrToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void parseByDelimeter(String inputValue) {

    }
}
