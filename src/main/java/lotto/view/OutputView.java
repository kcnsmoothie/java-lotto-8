package lotto.view;

import static lotto.constant.ViewMessage.*;

public class OutputView {
    public void printPurchaseResult(int purchaseAmount) {
        System.out.println(PURCHASE_RESULT_MESSAGE.getViewMessage(purchaseAmount));
    }
}
