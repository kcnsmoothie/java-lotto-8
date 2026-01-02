package lotto.view;

import static lotto.constant.ViewMessage.FIFTH_MESSAGE;
import static lotto.constant.ViewMessage.FIRST_MESSAGE;
import static lotto.constant.ViewMessage.FOURTH_MESSAGE;
import static lotto.constant.ViewMessage.HEADER;
import static lotto.constant.ViewMessage.PROFIT_RATE_MESSAGE;
import static lotto.constant.ViewMessage.PURCHASE_AMOUNT;
import static lotto.constant.ViewMessage.SECOND_MESSAGE;
import static lotto.constant.ViewMessage.THIRD_MESSAGE;

import java.util.Map;
import lotto.constant.Rank;

public class OutputView {
    public void printLottoAmount(int lottoAmount) {
        System.out.println(PURCHASE_AMOUNT.getViewMessage(lottoAmount));
    }

    public void printLottoHit(Map<Rank, Integer> rankResult) {
        System.out.println(HEADER.getViewMessage());
        System.out.println(FIRST_MESSAGE.getViewMessage(rankResult.getOrDefault(Rank.FIFTH, 0)));
        System.out.println(SECOND_MESSAGE.getViewMessage(rankResult.getOrDefault(Rank.FOURTH, 0)));
        System.out.println(THIRD_MESSAGE.getViewMessage(rankResult.getOrDefault(Rank.THIRD, 0)));
        System.out.println(FOURTH_MESSAGE.getViewMessage(rankResult.getOrDefault(Rank.SECOND, 0)));
        System.out.println(FIFTH_MESSAGE.getViewMessage(rankResult.getOrDefault(Rank.FIRST, 0)));
    }

    public void printProfitRate(double profitRate) {
        System.out.println(PROFIT_RATE_MESSAGE.getViewMessage(profitRate));
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
