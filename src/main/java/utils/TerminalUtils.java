package utils;

import domain.Player;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TerminalUtils {
    public static void print(String message) {
        System.out.print(message);
    }
    public static void println(String message) {
        System.out.println(message);
    }
    public static String printAndRead(String message) {
        var scanner = new Scanner(System.in);
        println(message);
        return  scanner.next();
    }
    public static void pressEnterKeyToContinue() {
        print("Press [ENTER] to continue...");
        try{
            System.in.read();
        }
        catch(IOException ex) {
            println(ex.getMessage());
        }
    }
    public static void logPosition(Player player, Integer position){
        var message = "[" + player.getClass().getSimpleName() + "] step: " + position;
        println(message);
    }

    public static void showTheScore(boolean isDraw, List<Player> players) {
        if (isDraw) {
            println("\n______________");
            println("   D R A W");
            println("______________");
        } else {
            println("\n__________________");
            println("   W I N N E R");
            println("-----------------");
            println("   " + players.get(0).getClass().getSimpleName());
            println("_________________");
        }
    }
}
