package lotto.view;

import static lotto.constant.ViewMessage.PURCHASE_AMOUNT;

public class OutputView {
    public void printLottoAmount(int lottoAmount) {
        System.out.println(PURCHASE_AMOUNT.getViewMessage(lottoAmount));
    }

    public void printLottoHit() {
    }

    public void printProfitRate() {

    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
