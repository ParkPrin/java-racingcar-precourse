package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

public class GameOperator implements GameInput{
    private int numberGames;
    private int numberTurns;

    public GameOperator(){
        ;
        this.numberTurns = 0;
    }

    public void runTurn(){
        this.numberTurns++;
    }

    public boolean isSameNumberGames(String numberGamesString){
        return Integer.parseInt(numberGamesString) == numberGames;
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
        if (numberGames < 1){
            throw new IllegalArgumentException("[ERROR] 입력한 값이 1이상이어야 합니다.");
        }
        return numberGames;
    }

    @Override
    public void gameStartInput(String input) {
        this.numberGames = numberGamesValidation(input);
    }
}
