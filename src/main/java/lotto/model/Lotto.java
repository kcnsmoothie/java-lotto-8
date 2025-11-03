package lotto.model;

import static lotto.util.Validator.validateNumberDuplicate;
import static lotto.util.Validator.validateWinningNumbersSize;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateWinningNumbersSize(numbers);
        validateNumberDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
