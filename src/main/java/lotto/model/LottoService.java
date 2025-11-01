package lotto.model;

import static lotto.constant.LottoNumberConstant.LOTTO_NUMBER_SIZE;
import static lotto.constant.LottoNumberConstant.LOTTO_PRICE;
import static lotto.constant.LottoNumberConstant.LOTTO_RANGE_MAX;
import static lotto.constant.LottoNumberConstant.LOTTO_RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoService {
    public LottoService() {
    }

    public int calculatePurchasableLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }

    //1~45 사이에서 중복되지 않는 숫자 6개를 뽑는 기능
    public List<Integer> makeRandomLottoNumbers() {
        List<Integer> randomLottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN.getValue(),
                LOTTO_RANGE_MAX.getValue(),
                LOTTO_NUMBER_SIZE.getValue());
        return randomLottoNumber;
    }

    //오름차순으로 로또를 정렬하는 기능
    public void sortAscending(List<Integer> randomLottoNumber) {
        Collections.sort(randomLottoNumber);
    }

    //발행 수량만큼 로또 발행
    public List<Lotto> lottoMaker(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = makeRandomLottoNumbers();
            sortAscending(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
