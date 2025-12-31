package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
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
        int purchaseAmount = getPurchaseAmount();
        int lottoQuantity = lottoService.calculateLottoQuantity(purchaseAmount);
        outputView.printLottoQuantity(lottoQuantity);
        List<Lotto> lottos = lottoService.createLotto(lottoQuantity);
        outputView.printPurchasedLotto(lottos);
        lottoService.createLotto(lottoQuantity);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.inputPurchaseAmount();
                Validator.validateNotBlank(inputPurchaseAmount);
                int purchaseAmount = Parser.parseStrToInt(inputPurchaseAmount);
                Validator.validateMutiplesOf1000(purchaseAmount);
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
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
