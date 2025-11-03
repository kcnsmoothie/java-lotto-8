package lotto.model;

import static lotto.constant.LottoNumberConstant.LOTTO_NUMBER_SIZE;
import static lotto.constant.LottoNumberConstant.LOTTO_PRICE;
import static lotto.constant.LottoNumberConstant.LOTTO_RANGE_MAX;
import static lotto.constant.LottoNumberConstant.LOTTO_RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.Rank;

public class LottoService {
    public LottoService() {
    }

    public int calculatePurchasableLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }

    public List<Integer> makeRandomLottoNumbers() {
        List<Integer> randomLottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN.getValue(),
                LOTTO_RANGE_MAX.getValue(),
                LOTTO_NUMBER_SIZE.getValue());
        return randomLottoNumber;
    }

    public void sortAscending(List<Integer> randomLottoNumber) {
        List<Integer> sorted = randomLottoNumber.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Lotto> lottoMaker(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = makeRandomLottoNumbers();
            sortAscending(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public Rank determineRank(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return Rank.SIX_MATCH;
        if (matchCount == 5 && bonusMatched) return Rank.FIVE_PLUS_BONUS_MATCH;
        if (matchCount == 5) return Rank.FIVE_MATCH;
        if (matchCount == 4) return Rank.FOUR_MATCH;
        if (matchCount == 3) return Rank.THREE_MATCH;
        return null;
    }

    public int calculateMatchCount(List<Integer> winningNumber,List<Integer> lotto) {
        long matchCount = winningNumber.stream()
                .filter(lotto::contains)
                .count();
        return (int) matchCount;
    }

    public boolean checkBonusNumber(List<Integer> lotto,int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private double calculateEntryPrize(Map.Entry<Rank, Integer> entry) {
        if (entry.getValue() == 0) {
            return 0;
        }
        return entry.getKey().getPrize() * entry.getValue();
    }

    public double calculateTotalPrize(Map<Rank, Integer> rankResult) {
        double totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankResult.entrySet()) {
            totalPrize += calculateEntryPrize(entry);
        }
        return totalPrize;
    }

    public double calculateProfitRate(double totalPrize, int purchaseAmount) {
        double profitRate = totalPrize / (double) purchaseAmount;
        return Math.round(profitRate) / 10.0;
    }
}
