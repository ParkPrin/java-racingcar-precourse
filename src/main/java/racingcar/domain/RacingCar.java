package racingcar.domain;

import java.util.Random;
import org.junit.platform.commons.util.StringUtils;

public class RacingCar {
    final private String name;
    private int travel;

    private RacingCar(String name){
        this.name = racingCarCreateValidation(name);
        this.travel = 0;
    }

    public String getName() {
        return name;
    }

    public int getTravel() {
        return travel;
    }

    public void runRacing() {
        this.travel = this.travel + goTravel();
    }

    private int goTravel(){
        int randomValue = (int)Math.random()*10;
        if (randomValue < 4){
            return 0;
        }
        return randomValue;
    }

    public static RacingCar getInstance(String name){
        return new RacingCar(name);
    }

    /**
     * 자동차 이름의 유효성검사
     * @param name
     * @return
     */
    private String racingCarCreateValidation(String name){
        // 자동차 이름이 존재하지 않는 경우
        if (StringUtils.isBlank(name)){
            throw new IllegalArgumentException("[ERROR] 값을 입력하세요.");
        }
        if (name.length() > 5){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
        return name;
    }
}
