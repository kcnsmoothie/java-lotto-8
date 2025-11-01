package lotto.controller;

import java.util.List;
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
        getPurchaseAmount();
        getWinningNumber();
    }

    public int getPurchaseAmount() {
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        Validator.validateNotBlank(inputPurchaseAmount);
        int purchaseAmount = Parser.stringToInt(inputPurchaseAmount);
        Validator.validateNotMultipleOfThousand(purchaseAmount);
        return purchaseAmount;
    }

    public void getWinningNumber() {
        String inputWinningNumber = inputView.inputWinningNumber();
        Validator.validateNotBlank(inputWinningNumber);
        List<String> parsedWinningNumber = Parser.parseWinningNumber(inputWinningNumber);
        List<Integer> winningNumber = Parser.stringListToIntList(parsedWinningNumber);
        Validator.validateWinningNumber(winningNumber);
    }
}
