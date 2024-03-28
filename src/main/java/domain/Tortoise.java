package domain;

public class Tortoise extends Player {


    public Tortoise(Integer finishLine) {
        super(finishLine);
    }

    // Tortoise Velocity can variable between 1 and 15 randomly
    @Override
    public Integer getVelocity() {
        return (int) Math.floor(Math.random() * 10 + 6);
    }
}
