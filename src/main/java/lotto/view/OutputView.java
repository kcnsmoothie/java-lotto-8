package lotto.view;

import static lotto.constant.ViewMessage.*;
import static lotto.constant.Rank.*;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.Rank;

public class OutputView {
    public void printPurchaseResult(int purchaseAmount) {
        System.out.println(PURCHASE_RESULT_MESSAGE.getViewMessage(purchaseAmount));
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printRankResult(Map<Rank, Integer> rankResult) {
        System.out.println(STATISTICS_HEADER.getViewMessage());
        System.out.println(FIFTH_PLACE_MESSAGE.getViewMessage(rankResult.getOrDefault(THREE_MATCH, 0)));
        System.out.println(FOURTH_PLACE_MESSAGE.getViewMessage(rankResult.getOrDefault(FOUR_MATCH, 0)));
        System.out.println(THIRD_PLACE_MESSAGE.getViewMessage(rankResult.getOrDefault(FIVE_MATCH, 0)));
        System.out.println(SECOND_PLACE_MESSAGE.getViewMessage(rankResult.getOrDefault(FIVE_PLUS_BONUS_MATCH, 0)));
        System.out.println(FIRST_PLACE_MESSAGE.getViewMessage(rankResult.getOrDefault(SIX_MATCH, 0)));
    }
}
