package lotto.view;

import static lotto.constant.ViewMessage.OUTPUT_LOTTO_QUANTITY;

public class OutputView {
    public void printLottoQuantity(int lottoQuantity) {
        System.out.println(OUTPUT_LOTTO_QUANTITY.getViewMessage(lottoQuantity));
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
