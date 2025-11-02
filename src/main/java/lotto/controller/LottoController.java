package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.model.LottoService;
import lotto.model.Parser;
import lotto.model.Validator;
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
        int purchaseAmount = getPurchaseAmount();
        outputView.printPurchaseResult(purchaseAmount);
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);
        lottoService.lottoMaker(purchaseAmount);
    }

    public int getPurchaseAmount() {
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        Validator.validateNotBlank(inputPurchaseAmount);
        int parsedPurchaseAmount = Parser.stringToInt(inputPurchaseAmount);
        Validator.validateNotMultipleOfThousand(parsedPurchaseAmount);
        int purchaseAmount = lottoService.calculatePurchasableLottoCount(parsedPurchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> getWinningNumber() {
        String inputWinningNumber = inputView.inputWinningNumber();
        Validator.validateNotBlank(inputWinningNumber);
        List<String> parsedWinningNumber = Parser.parseWinningNumber(inputWinningNumber);
        List<Integer> winningNumber = Parser.stringListToIntList(parsedWinningNumber);
        Validator.validateWinningNumber(winningNumber);
        return new ArrayList<>(winningNumber);
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        String inputBonusNumber = inputView.inputBonusNumber();
        Validator.validateNotBlank(inputBonusNumber);
        int bonusNumber = Parser.stringToInt(inputBonusNumber);
        Validator.validateBonusNumber(winningNumber,bonusNumber);
        return bonusNumber;
    }
}
