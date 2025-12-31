package lotto.view;

import static lotto.constant.ViewMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.ViewMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.ViewMessage.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getViewMessage());
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER.getViewMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getViewMessage());
        return Console.readLine();
    }
}
