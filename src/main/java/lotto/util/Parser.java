package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.constant.ErrorMessage.*;

public class Parser {
    public static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    public static List<Integer> stringToInt(List<String> parsedWinningNumber) {
        try {
            return parsedWinningNumber.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    public static List<String> parseWinningNumber(String inputWinningNumber) {
        List<String> parsedWinningNumber = new ArrayList<>();
        Arrays.stream(inputWinningNumber.split(","))
                .map(String::trim)
                .forEach(parsedWinningNumber::add);
        return parsedWinningNumber;
    }
}