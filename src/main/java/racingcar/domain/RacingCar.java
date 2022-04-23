package racingcar.domain;

public class RacingCar {
    final private String name;
    private int travel;

    public RacingCar(String name){
        this.name = name;
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
}
