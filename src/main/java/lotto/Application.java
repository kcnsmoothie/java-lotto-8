package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoService;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoController lottoController;
        LottoService lottoService = new LottoService();

        lottoController = new LottoController(inputView, lottoService);

        lottoController.run();
    }
}
