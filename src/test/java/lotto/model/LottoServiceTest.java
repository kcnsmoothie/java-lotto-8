package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("로또 발행 수량 계산 - 성공")
    void calculatePurchasableLottoCount_test(){
        //given
        int purchaseAmount = 3000;

        //when
        Integer result = lottoService.calculatePurchasableLottoCount(purchaseAmount);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("1~45 사이에서 중복되지 않는 숫자 6개 뽑기 - 성공")
    void makeRandomLottoNumbers_test(){
        //when
        List<Integer> result = lottoService.makeRandomLottoNumbers();
        //then
        assertThat(result).hasSize(6);
        assertThat(result)
                .allMatch(num -> num >= 1 && num <= 45);
        assertThat(new HashSet<>(result)).hasSize(6);
    }

    @Test
    @DisplayName("리스트 오름차순 정렬 검사")
    void sortAscending_test(){
        //given
        List<Integer> list = Arrays.asList(12,9,3,5,8,1);
        List<Integer> expectedResult = Arrays.asList(1,3,5,8,9,12);
        //when
        lottoService.sortAscending(list);
        //then
        assertThat(list).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("로또 발행 수량만큼 발행되는지 검사")
    void lottoMaker_test(){
        // given
        int lottoCount = 5;
        // when
        List<Lotto> lottos = lottoService.lottoMaker(lottoCount);
        // then
        assertThat(lottos).hasSize(lottoCount);
    }

    @Test
    @DisplayName("구매한 로또 번호와 당첨 번호 중 일치하는 숫자의 개수 검사")
    void calcualteMatchCount_test(){
        // given
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);
        List<Integer> lotto = Arrays.asList(1,4,3,2,5,8);

        // when
        int result = lottoService.calculateMatchCount(winningNumber,lotto);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("보너스 번호가 포함되어있는지 계산해주는 검사")
    void checkBonusNumber_test(){
        // given
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 1;

        // when
        boolean result = lottoService.checkBonusNumber(lotto, bonusNumber);

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("총 상금 계산 검사")
    void calculateTotalPrize_test(){
        // given
        Map<Rank, Integer> rankResult = new LinkedHashMap<>();
        rankResult.put(Rank.THREE_MATCH, 1);           // 3개 맞음: 1개
        rankResult.put(Rank.FOUR_MATCH, 2);            // 4개 맞음: 2개
        rankResult.put(Rank.FIVE_MATCH, 0);            // 5개 맞음: 0개
        rankResult.put(Rank.FIVE_PLUS_BONUS_MATCH, 1); // 5+보너스: 1개
        rankResult.put(Rank.SIX_MATCH, 0);             // 6개 맞음: 0개

        // when
        double result = lottoService.calculateTotalPrize(rankResult);

        // then
        double expectedResult = 1 * Rank.THREE_MATCH.getPrize() +
                        2 * Rank.FOUR_MATCH.getPrize() +
                        0 * Rank.FIVE_MATCH.getPrize() +
                        1 * Rank.FIVE_PLUS_BONUS_MATCH.getPrize() +
                        0 * Rank.SIX_MATCH.getPrize();

        assertThat(result).isEqualTo(expectedResult);
    }
}
