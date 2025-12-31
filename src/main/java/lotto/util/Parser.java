package lotto.util;

import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static int parseStrToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    public static List<Integer> parseStrToInt(List<String> parsedList) {
        try {
            return parsedList.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
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
