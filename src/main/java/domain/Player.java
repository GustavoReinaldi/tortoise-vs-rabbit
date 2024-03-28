package domain;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

import static utils.TerminalUtils.*;

public abstract class Player implements Runnable{
    private Integer positionInMap;
    private Integer velocity;
    private Integer finishLine;
    private Long raceFinishedAt;

    public Player(Integer finishLine) {
        this.finishLine = finishLine;
        this.positionInMap = 0;
    }

    public Integer getVelocity() {
        return this.velocity;
    }

    public Long getRaceFinishedAt() {
        return raceFinishedAt;
    }

    public Integer getPositionInMap() {
        return this.positionInMap;
    }

    @Override
    public void run() {
        try {
            do {
                Thread.sleep(1000 / this.getVelocity());
                this.positionInMap += 1;
//                logPosition(this, this.positionInMap);

            } while (positionInMap != finishLine);
            raceFinishedAt = Instant.now().toEpochMilli();

        } catch (InterruptedException ignored) {}

    }

}
