package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    @DisplayName("입력받은 문자열 -> 정수형 형변환 검사")
    void stringToInt_test(){
        String string = "hello";

        assertThatThrownBy(() -> Parser.stringToInt(string))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
