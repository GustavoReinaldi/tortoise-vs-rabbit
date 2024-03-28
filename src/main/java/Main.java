import service.Race;

import static utils.TerminalUtils.*;


public class Main {
    public static void main(String[] args) {
        println("Let's start this race!");
        pressEnterKeyToContinue();

        var raceFinishLine = Integer.parseInt(printAndRead("How long this Race will be?"));
        var race = new Thread(new Race(raceFinishLine), "Race Thread");
        try {
            race.start();
            race.join(); // Waits for the RACE thread to finish its work to interrupt it
            race.interrupt();
        } catch (InterruptedException ignored) {
        }

    }


}
