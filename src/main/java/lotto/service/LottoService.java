package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottoService {
    public int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }


    public List<Lotto> createLotto(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = Lotto.randomNumbersOf(numbers);
            System.out.println(lotto.toString());
            lottos.add(lotto);
        }
        return lottos;
    }
}
