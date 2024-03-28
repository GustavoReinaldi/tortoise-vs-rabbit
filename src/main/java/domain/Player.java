package domain;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

import static utils.TerminalUtils.*;

public abstract class Player implements Runnable{
    private Integer positionInMap;
    private Integer finishLine;
    private Long raceFinishedAt;

    public Player(Integer finishLine) {
        this.finishLine = finishLine;
        this.positionInMap = 0;
    }

    public Integer getVelocity() {
        return 0;
    }

    public Long getRaceFinishedAt() {
        return raceFinishedAt;
    }


    @Override
    public void run() {
        println("Player [" + this.getClass().getSimpleName() + "] started");
        try {
            do {
                Thread.sleep(1000 / this.getVelocity());
                this.positionInMap += 1;

            } while (positionInMap != finishLine);
            raceFinishedAt = Instant.now().toEpochMilli();
            println("Player [" + this.getClass().getSimpleName() + "] finished");
        } catch (InterruptedException ignored) {}

    }

}
