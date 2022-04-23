package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @DisplayName("레이싱카 생성 테스트 - 실패(이름없음)")
    @Test
    void createRacingCarValidationTestToFailAtNullName(){
        // given
        String name = "";

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    RacingCar racingcar = new RacingCar(name)            ;
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름을 입력하세요.");
    }

    @DisplayName("레이싱카 생성 테스트 - 실패(이름5자초과)")
    @Test
    void createRacingCarValidationTestToFailAtOver5Name(){
        // given
        String name = "racingCar";

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    RacingCar racingcar = new RacingCar(name)            ;
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("레이싱카 생성 테스트 - 성공")
    @Test
    void createRacingCarValidationTestToSuccess(){
        // given
        String name = "jimi";

        // when
        RacingCar racingcar = new RacingCar(name);

        // then
        assertEquals(racingcar.getName(), name);

    }

}