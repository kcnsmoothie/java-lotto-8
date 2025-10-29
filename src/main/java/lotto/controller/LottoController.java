package lotto.controller;

import lotto.model.LottoService;
import lotto.model.Parser;
import lotto.model.Validator;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView,LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void run() {

    }

    public int getPurchaseAmount() {
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        //빈값 혹은 null인지 검증
        Validator.validateNotBlank(inputPurchaseAmount);
        // String을 int로 형변환
        int purchaseAmount = Parser.stringToInt(inputPurchaseAmount);
        // int값이 올바른지 유효성 검증
        Validator.validateNumericAmount(purchaseAmount);
        //입력값 반환
        return purchaseAmount;
    }
}
