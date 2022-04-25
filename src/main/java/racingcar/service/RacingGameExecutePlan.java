package racingcar.service;

import java.util.Scanner;
import racingcar.domain.CarManager;
import racingcar.domain.GameInput;
import racingcar.domain.GameOperator;

public class RacingGameExecutePlan {
    Scanner scanner;
    public RacingGameExecutePlan(){
        scanner = new Scanner(System.in);
    }

    public void gameExecutePlan(){
        GameInput carManager = new CarManager();
        gameInfoInput(carManager, "경주할자동차이름(이름은쉼표(,)기준으로구분)");
        GameInput gameOperator = new GameOperator();
        gameInfoInput(gameOperator, "시도할회수");
        final RacingGameService racingGameService = new RacingGameService((CarManager)carManager, (GameOperator)gameOperator);
        racingGameService.runRacingGame();
        racingGameService.runGameResultPrint();
    }

    public void gameInfoInput(GameInput carManager, String remark){
        boolean isGameDataInput = false;
        System.out.println(remark);
        while (!isGameDataInput) {
            try {
                carManager.gameStartInput(scanner.next());
                isGameDataInput = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println(remark);
            }
        }
    }
}
