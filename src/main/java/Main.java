import service.Race;

import static utils.TerminalUtils.*;


public class Main {
    public static void main(String[] args) {
        println("Let's start this race!");
        pressEnterKeyToContinue();

        var startAgain = false;
        do {
            var raceFinishLine = 0;
            while (raceFinishLine == 0) {
                raceFinishLine = Integer.parseInt(printAndRead("How long this Race will be? (5 - 100)"));
                if (raceFinishLine < 5 || raceFinishLine > 100) {
                    println("Only numbers in the range of 5 and 100 is allowed!\n");
                    raceFinishLine = 0;
                }
            }

            var race = new Thread(new Race(raceFinishLine), "Race Thread");
            try {
                race.start();
                race.join(); // Waits for the RACE thread to finish its work to interrupt it
                race.interrupt();
            } catch (InterruptedException ignored) {
            }
            startAgain = printAndRead("Do you want to start again? [Y]-yes / [N]-no").equalsIgnoreCase("Y");
        } while (startAgain);
    }


}
