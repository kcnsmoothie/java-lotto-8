package lotto.controller;

import lotto.model.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView,LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void run() {
        inputView.inputBonusNumber();
    }
}
