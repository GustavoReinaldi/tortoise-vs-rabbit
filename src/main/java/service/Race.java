package service;

import domain.Player;
import domain.Rabbit;
import domain.Tortoise;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static utils.TerminalUtils.showTheScore;
import static utils.TerminalUtils.println;

public class Race implements Runnable {
    private boolean draw;
    private List<Player> players;
    private int finishLine = 100;
    private long raceStartedAt;

    public Race(int finishLine) {
        players = new ArrayList<>();
        this.finishLine = finishLine;
        this.draw = false;
        this.createCharacters();
    }

    @Override
    public void run() {
        var rabbitThread = new Thread(this.players.get(0), "Rabbit Thread");
        var tortoiseThread = new Thread(this.players.get(1), "Tortoise Thread");


        println("RACE STARTED");
        this.raceStartedAt = Instant.now().toEpochMilli();
        rabbitThread.start();
        tortoiseThread.start();

        try {
            rabbitThread.join();
            tortoiseThread.join();
        } catch (InterruptedException ignored) {}

        rabbitThread.interrupt();
        tortoiseThread.interrupt();
        createTheScoreStats();
        showTheScore(this.draw, players);
    }

    private void createCharacters() {
        this.players.add(new Rabbit(finishLine));
        this.players.add(new Tortoise(finishLine));
    }
    private void createTheScoreStats() {
        players.sort(Comparator.comparingLong(Player::getRaceFinishedAt));
        long lowerTime = players.get(0).getRaceFinishedAt();
        // if more than 1 player
        this.draw = players.stream().filter(player -> player.getRaceFinishedAt() == lowerTime).count() > 1;
    }
}
