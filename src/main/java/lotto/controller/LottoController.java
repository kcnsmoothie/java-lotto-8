package lotto.controller;

import java.util.Arrays;
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
        int purchaseAmount = getPurchaseAmount();
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);
    }

    public int getPurchaseAmount() {
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        Validator.validateNotBlank(inputPurchaseAmount);
        int purchaseAmount = Parser.stringToInt(inputPurchaseAmount);
        Validator.validateNotMultipleOfThousand(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> getWinningNumber() {
        String inputWinningNumber = inputView.inputWinningNumber();
        Validator.validateNotBlank(inputWinningNumber);
        List<String> parsedWinningNumber = Parser.parseWinningNumber(inputWinningNumber);
        List<Integer> winningNumber = Parser.stringListToIntList(parsedWinningNumber);
        Validator.validateWinningNumber(winningNumber);
        return winningNumber;
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        String inputBonusNumber = inputView.inputBonusNumber();
        Validator.validateNotBlank(inputBonusNumber);
        int bonusNumber = Parser.stringToInt(inputBonusNumber);
        //기존 당첨 번호 리스트에 보너스 값을 추가해주기
        winningNumber.add(bonusNumber);
        Validator.validateBonusNumber(winningNumber,bonusNumber);
        return bonusNumber;
    }
}
