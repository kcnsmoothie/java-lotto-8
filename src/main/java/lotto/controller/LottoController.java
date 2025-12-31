package lotto.controller;

import lotto.service.LottoService;
import lotto.util.Parser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {

    }

    private void getPurchaseAmount() {
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        Validator.validateNotBlank(inputPurchaseAmount);
        int purchaseAmount = Parser.parseStrToInt(inputPurchaseAmount);
        Validator.validateMutiplesOf1000(purchaseAmount);
    }
}
