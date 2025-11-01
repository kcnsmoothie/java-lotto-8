package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.Lotto;
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
}
