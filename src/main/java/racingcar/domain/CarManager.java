package racingcar.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.platform.commons.util.StringUtils;
import racingcar.domain.RacingCar;

public class CarManager {
    private Map<String, RacingCar> racingJoinCars;
    public CarManager(){
        racingJoinCars = new HashMap<>();
    }

    public void startRacingGame(String input){
        racingGamePlayerNameInputValidation(input);
        joinRacingCars(racingJoinCarNames(input));
    }

    private String[] racingJoinCarNames(String input){
        return input.split(",");
    }

    private RacingCar joinRacingCar(String name){
        RacingCar racingCar = null;
        try{
            racingCar = RacingCar.getInstance(name);
        } catch(IllegalArgumentException e){
            racingJoinCars.clear();
        }
        return racingCar;
    }

    private void joinRacingCars(String[] racingJoinCarNames){
        Arrays.asList(racingJoinCarNames).forEach(racingJoinCarName -> {
            isSameNameRacingCarValidation(racingJoinCarName);
            racingJoinCars.put(racingJoinCarName, joinRacingCar(racingJoinCarName));
        });
    }

    private void isSameNameRacingCarValidation(String racingJoinCarName){
        if (racingJoinCars.containsKey(racingJoinCarName)){
            racingJoinCars.clear();
            throw new IllegalArgumentException("[ERROR] 레이싱게임에 동일한 이름의 참가자가 존재합니다.");
        }
    }

    private void racingGamePlayerNameInputValidation(String input){
        if (StringUtils.isBlank(input)){
            throw new IllegalArgumentException("[ERROR] 값을 입력하세요.");
        }
    }

    public Map<String, RacingCar> getJoinRacingCarsMap(){
        return racingJoinCars;
    }
}
