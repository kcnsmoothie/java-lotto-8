package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import static lotto.constant.ViewMessage.*;

public class InputView {

    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE.getInputMessage());
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE.getInputMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE.getInputMessage());
        return Console.readLine();
    }
}
