package lotto.view;

import static lotto.constant.ViewMessage.INPUT_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getViewMessage());
        return Console.readLine();
    }
}
