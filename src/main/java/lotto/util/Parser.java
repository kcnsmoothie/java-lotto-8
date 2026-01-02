package lotto.util;

import static lotto.constant.ErrorMessage.DEFAULT_MESSAGE;

public class Parser {
    public static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE.getErrorMessage());
        }
    }
}
