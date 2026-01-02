package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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
}
