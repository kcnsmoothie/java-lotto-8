package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static int stringToInt(String string){
        int castedInt = Integer.parseInt(string);
        return castedInt;
    }

    public static List<String> parseWinningNumber(String inputWinningNumber) {
        List<String> parsedWinningNumber = new ArrayList<>();
        Arrays.stream(inputWinningNumber.split(","))
                .map(String::trim)
                .forEach(parsedWinningNumber::add);
        return parsedWinningNumber;
    }

    public static List<Integer> stringListToIntList(List<String> parsedWinningNumber) {
        List<Integer> winningNumber = parsedWinningNumber.stream()
                .map(Integer::parseInt)
                .toList();
        return winningNumber;
    }
}
