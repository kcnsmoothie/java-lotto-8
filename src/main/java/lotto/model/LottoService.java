package lotto.model;

import static lotto.constant.LottoNumberConstant.LOTTO_PRICE;

public class LottoService {
    public LottoService() {
    }

    public int calculatePurchasableLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }
}
