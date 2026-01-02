package lotto.controller;

import java.util.List;
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
}
