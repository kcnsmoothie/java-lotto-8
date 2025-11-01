package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
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
    @Test
    @DisplayName("구분자(,)단위로 파싱 및 순서대로 저장 검사")
    void parseWinningNumber_test(){
        //given
        String string = "1,2,3,4";
        //when
        List<String> parsedWinningNumbers = Parser.parseWinningNumber(string);
        //then
        assertThat(parsedWinningNumbers).elements(0, 1, 2, 3).contains("1", "2", "3", "4");
    }

    @Test
    @DisplayName("문자열 리스트를 정수형 리스트로 변환해주는 검사")
    void stringListToIntList_test(){
        //given
        List<String> list = Arrays.asList("1","2","3","4");
        //when
        List<Integer> winningNumber = Parser.stringListToIntList(list);
        //then
        assertThat(winningNumber).elements(0, 1, 2, 3).contains(1,2,3,4);
    }
}
