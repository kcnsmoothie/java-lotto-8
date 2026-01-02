package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
import lotto.service.Lotto;
import lotto.service.LottoService;
import lotto.util.Parser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView; //private final로 설정
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int lottoAmount = lottoService.calculateLottoAmount(purchaseAmount);
        outputView.printLottoAmount(lottoAmount);
        List<Lotto> lottos = lottoService.createRandomLotto(lottoAmount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.inputPurchaseAmount();
                int purchaseAmount = Parser.stringToInt(inputPurchaseAmount);
                Validator.validateMultipleOfThousand(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<Integer> getWinningNumber() {
        while (true) {
            try {
                String inputWinningNumber = inputView.inputWinningNumber();
                List<String> parsedWinningNumber = Parser.parseByDelimeter(inputWinningNumber);
                List<Integer> winningNumber = Parser.stringToInt(parsedWinningNumber);
                Validator.validateNotDuplicate(winningNumber);
                Validator.validateSize(winningNumber);
                for (int number : winningNumber) {
                    Validator.validateInRange(number);
                }
                return winningNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                int bonusNumber = Parser.stringToInt(inputBonusNumber);
                Validator.validateInRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private double getProfitRate(int purchaseAmount) {
        double totalPrize = lottoService.calculateTotalPrize();
        double proitRate = lottoService.calculateProfitRate(totalPrize, purchaseAmount);
    }
}
