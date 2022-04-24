package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import racingcar.domain.CarManager;
import racingcar.domain.GameOperator;
import racingcar.domain.RacingCar;

public class RacingGameService {
    private CarManager carManager;
    private GameOperator gameOperator;

    public RacingGameService(CarManager carManager, GameOperator gameOperator){
        this.carManager = carManager;
        this.gameOperator = gameOperator;
    }

    public void runRacingGame(){
        System.out.println("실행 결과");
        while(!gameOperator.isTurnEnd()){
            final Map<String, RacingCar> joinRacingCarsMap = carManager.getJoinRacingCarsMap();
            Arrays.asList(carManager.getRacingJoinCarNames()).forEach(racingCarName -> {
                RacingCar racingCar = joinRacingCarsMap.get(racingCarName);
                System.out.println(racingCarName + ": " + racingCar.getTravel());
                racingCar.runRacing();
            });
            gameOperator.runTurn();
            System.out.println();
        }
    }

    public void runGameResultPrint(){
        carManager.racingGameWinnerPrint();
    }
}
