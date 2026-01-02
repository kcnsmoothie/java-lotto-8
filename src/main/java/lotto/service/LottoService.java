package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.constant.Rank;

public class LottoService {
    public int calculateLottoAmount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public List<Lotto> createRandomLotto(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public Map<Rank, Integer> calculateRank(List<Integer> winningNumber, int bonusNumber, List<Lotto> lottos) {
        Map<Rank, Integer> lottoHit = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoHit.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            int matchCount = 0;
            List<Integer> matchNumbers = lotto.getNumbers().stream().filter(o -> winningNumber.stream().anyMatch(
                    Predicate.isEqual(o))).collect(Collectors.toList());
            matchCount = matchNumbers.size();
            for (Rank rank : Rank.values()) {
                if (matchCount == rank.getWinningHit()) {
                    lottoHit.put(rank, 1);
                }
            }
        }
        return lottoHit;
    }

    public double calculateTotalPrize(Map<Rank, Integer> lottoHit) {
        double totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : lottoHit.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }

    public double calculateProfitRate(double totalPrize, int purchaseAmount) {
        return (double) totalPrize / purchaseAmount;
    }
}
