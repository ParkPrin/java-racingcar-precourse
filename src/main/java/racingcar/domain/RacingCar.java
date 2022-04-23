package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

public class RacingCar {
    final private String name;
    private int travel;

    public RacingCar(String name){
        this.name = racingCarCreateValidation(name);
        this.travel = 0;
    }

    public String getName() {
        return name;
    }

    public int getTravel() {
        return travel;
    }

    public void raingDistance(int travel) {
        this.travel = this.travel + travel;
    }

    /**
     * 자동차 이름의 유효성검사
     * @param name
     * @return
     */
    private String racingCarCreateValidation(String name){
        // 자동차 이름이 존재하지 않는 경우
        if (StringUtils.isBlank(name)){
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력하세요");
        }
        if (name.length() > 5){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다");
        }
        return name;
    }
}
