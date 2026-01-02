package lotto.util;

import static lotto.constant.ErrorMessage.DEFAULT_MESSAGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE.getErrorMessage());
        }
    }

    public static List<Integer> stringToInt(List<String> parsedNumber) {
        try {
            return parsedNumber.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE.getErrorMessage());
        }
    }

    public static List<String> parseByDelimeter(String inputValue) {
        List<String> parsedList = new ArrayList<>();
        Arrays.stream(inputValue.split(","))
                .map(String::trim)
                .forEach(parsedList::add);
        return parsedList;
    }
}
