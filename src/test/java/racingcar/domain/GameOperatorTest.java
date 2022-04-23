package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameOperatorTest {

    @DisplayName("레이싱카 게임 진행 횟수 입력 테스트 - 실패(입력값없음)")
    @ParameterizedTest
    @CsvSource(value = {"null"}, nullValues={"null"})
    void gameOperationInputNumberGamesToFailAtInputNull(String numberGamesString){
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    new GameOperator(numberGamesString);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 값을 입력하세요.");
    }

    @DisplayName("레이싱카 게임 진행 횟수 입력 테스트 - 실패(입력값 숫자 아님)")
    @Test
    void gameOperationInputNumberGamesToFailAtNotInputNumber(){
        // given
        String numberGamesString = "abc";

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    new GameOperator(numberGamesString);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력한 값이 숫자가 아닙니다.");
    }

    @DisplayName("레이싱카 게임 진행 횟수 입력 테스트 - 실패(1미만인경우)")
    @ParameterizedTest
    @CsvSource(value = {"0", "-1"})
    void gameOperationInputNumberGamesToFailAtNumberLessOne(String numberGamesString){

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    new GameOperator(numberGamesString);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력한 값이 1이상이어야 합니다.");
    }

    @DisplayName("레이싱카 게임 진행 횟수 입력 테스트 - 실패(1미만인경우)")
    @ParameterizedTest
    @CsvSource(value = {"2", "10", "100"})
    void gameOperationInputNumberGamesToSuccess(String numberGamesString) {

        // when
        final GameOperator gameOperator = new GameOperator(numberGamesString);

        assertTrue(gameOperator.isSameNumberGames(numberGamesString));

    }
}