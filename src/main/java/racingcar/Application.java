package racingcar;

import java.util.Scanner;
import racingcar.domain.CarManager;
import racingcar.domain.GameOperator;
import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할자동차이름(이름은쉼표(,)기준으로구분)");
        Scanner scanner = new Scanner(System.in);
        CarManager carManager = new CarManager();
        boolean isRacingCarRegister = false;
        while (!isRacingCarRegister) {
            try {
                carManager.startRacingGame(scanner.next());
                isRacingCarRegister = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                isRacingCarRegister = false;
                System.out.println("경주할자동차이름(이름은쉼표(,)기준으로구분)");
            }
        }
        System.out.println("시도할회수");
        boolean isNumberGamesInputPass = false;
        GameOperator gameOperator = null;
        while (!isNumberGamesInputPass) {
            try {
                gameOperator = new GameOperator(scanner.next());
                isNumberGamesInputPass = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                isNumberGamesInputPass = false;
                System.out.println("시도할회수");
            }
        }

        final RacingGameService racingGameService = new RacingGameService(carManager, gameOperator);
        racingGameService.runRacingGame();
        racingGameService.runGameResultPrint();
    }
}
