package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

public class GameOperator {
    final private int numberGames;
    private int numberTurns;

    public GameOperator(String numberGamesString){
        this.numberGames = numberGamesValidation(numberGamesString);
        this.numberTurns = 0;
    }

    public void runTurn(){
        this.numberTurns++;
    }

    public boolean isTurnEnd(){
        return numberGames == numberTurns;
    }

    private int numberGamesValidation(String numberGamesString){
        if (StringUtils.isBlank(numberGamesString)) {
            throw new IllegalArgumentException("[ERROR] 값을 입력하세요.");
        }
        if (!numberGamesString.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }
        int numberGames = Integer.parseInt(numberGamesString);
        if (numberGames == 0){
            throw new IllegalArgumentException("[ERROR] 입력한 값이 1이상이어야 합니다");
        }
        return numberGames;
    }
}
