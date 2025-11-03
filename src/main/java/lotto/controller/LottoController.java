package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.constant.Rank;
import lotto.model.LottoService;
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
        int lottoCount = lottoService.calculatePurchasableLottoCount(purchaseAmount);
        outputView.printPurchaseResult(lottoCount);
        List<Lotto> lottos = lottoService.lottoMaker(lottoCount);
        outputView.printLotto(lottos);
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);
        Map<Rank, Integer> rankResult = getRankResult(lottos, winningNumber, bonusNumber);
        outputView.printRankResult(rankResult);
        double profitRate = getProfitRate(rankResult, purchaseAmount);
        outputView.printTotalProfitRate(profitRate);
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.inputPurchaseAmount();
                Validator.validateNotBlank(inputPurchaseAmount);
                int parsedPurchaseAmount = Parser.stringToInt(inputPurchaseAmount);
                Validator.validateNotMultipleOfThousand(parsedPurchaseAmount);
                return parsedPurchaseAmount;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public List<Integer> getWinningNumber() {
        while (true){
            try {
                String inputWinningNumber = inputView.inputWinningNumber();
                Validator.validateNotBlank(inputWinningNumber);
                List<String> parsedWinningNumber = Parser.parseWinningNumber(inputWinningNumber);
                List<Integer> winningNumber = Parser.stringToInt(parsedWinningNumber);
                Validator.validateWinningNumber(winningNumber);
                return new ArrayList<>(winningNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                Validator.validateNotBlank(inputBonusNumber);
                int bonusNumber = Parser.stringToInt(inputBonusNumber);
                Validator.validateBonusNumber(winningNumber, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public Map<Rank, Integer> getRankResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> lottoResult = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            int matchCount = lottoService.calculateMatchCount(winningNumbers, lotto.getNumbers());
            boolean bonusMatched = (matchCount == 5) && lottoService.checkBonusNumber(lotto.getNumbers(), bonusNumber);
            Rank rank = lottoService.determineRank(matchCount, bonusMatched);
            if (rank != null) {
                lottoResult.put(rank, lottoResult.get(rank) + 1);
            }
        }
        return lottoResult;
    }

    public double getProfitRate(Map<Rank, Integer> rankResult,int purchaseAmount) {
        double totalPrize = lottoService.calculateTotalPrize(rankResult);
        return lottoService.calculateProfitRate(totalPrize,purchaseAmount);
    }
}
