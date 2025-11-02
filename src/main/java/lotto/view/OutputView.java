package lotto.view;

import static lotto.constant.ViewMessage.*;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public void printPurchaseResult(int purchaseAmount) {
        System.out.println(PURCHASE_RESULT_MESSAGE.getViewMessage(purchaseAmount));
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
