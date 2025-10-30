package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
