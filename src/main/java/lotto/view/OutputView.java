package lotto.view;

import static lotto.constant.ViewMessage.OUTPUT_LOTTO_QUANTITY;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void printLottoQuantity(int lottoQuantity) {
        System.out.println(OUTPUT_LOTTO_QUANTITY.getViewMessage(lottoQuantity));
    }

    public void printPurchasedLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.toString();
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
