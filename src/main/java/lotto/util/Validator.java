package lotto.util;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoNumberConstant.LOTTO_NUMBER_SIZE;
import static lotto.constant.LottoNumberConstant.LOTTO_RANGE_MAX;
import static lotto.constant.LottoNumberConstant.LOTTO_RANGE_MIN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumberConstant.*;

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
        List<Integer> tempList = new ArrayList<>(winningNumber);
        tempList.add(bonusNumber);
        validateNumberDuplicate(tempList);
        validateNumberRange(bonusNumber);
    }

    public static void validateWinningNumbersSize(List<Integer> winningNumber){
        if(winningNumber.size() != LOTTO_NUMBER_SIZE.getValue()){
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_SIZE_ERROR.getErrorMessage());
        }
    }

    public static void validateNumberRange(int number){
        if (number < LOTTO_RANGE_MIN.getValue() || number > LOTTO_RANGE_MAX.getValue()) {
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
