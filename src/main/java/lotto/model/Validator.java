package lotto.model;

import static lotto.constant.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class Validator {
    public static void validateNotBlank(String inputValue) {
        if (inputValue == null || inputValue.isBlank()){
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR.getErrorMessage());
        }
    }

    public static void validateNotMultipleOfThousand(int inputValue) {
        if (inputValue % 1000 != 0){
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_1000_ERROR.getErrorMessage());
        }
    }

    public static void validateWinningNumber(List<Integer> winningNumber) {
        validateWinningNumbersSize(winningNumber);
        validateNumberDuplicate(winningNumber);
        for (int number : winningNumber) {
            validateNumberRange(number);
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        winningNumber.add(bonusNumber);
        validateNumberDuplicate(winningNumber);
        validateNumberRange(bonusNumber);
    }

    public static void validateWinningNumbersSize(List<Integer> winningNumber){
        if(winningNumber.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_SIZE_ERROR.getErrorMessage());
        }
    }

    public static void validateNumberRange(int number){
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    public static void validateNumberDuplicate(List<Integer> winningNumber) {
        Set<Integer> validatorSet = new HashSet<>(winningNumber);
        if(validatorSet.size()!= winningNumber.size()){
            throw new IllegalArgumentException(INVALID_NUMBER_DUPLICATE_ERROR.getErrorMessage());
        }
    }
}
