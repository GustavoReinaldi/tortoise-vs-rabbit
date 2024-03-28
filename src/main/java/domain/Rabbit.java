package domain;

public class Rabbit extends Player {

    public Rabbit(Integer finishLine) {
        super(finishLine);
    }

    // Rabbits velocity is constant
    @Override
    public Integer getVelocity() {
        return 10;
    }


}
