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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.constant.Rank;

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

    public Rank determineRank(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return Rank.SIX_MATCH;
        if (matchCount == 5 && bonusMatched) return Rank.FIVE_PLUS_BONUS_MATCH;
        if (matchCount == 5) return Rank.FIVE_MATCH;
        if (matchCount == 4) return Rank.FOUR_MATCH;
        if (matchCount == 3) return Rank.THREE_MATCH;
        return null;
    }

    //구매한 로또 번호와 당첨 번호 중 일치하는 숫자의 개수 계산
    public int calculateMatchCount(List<Integer> winningNumber,List<Integer> lotto) {
        long matchCount = winningNumber.stream()
                .filter(lotto::contains)
                .count();
        return (int) matchCount;
    }

    //일치하는 숫자가 5개일 때만 보너스 값 검사
    //보너스 값과 일치하는 숫자가 있는지 검사
    public boolean checkBonusNumber(List<Integer> lotto,int bonusNumber) {
        boolean isBonusMatched = lotto.contains(bonusNumber);
        return isBonusMatched;
    }
}
