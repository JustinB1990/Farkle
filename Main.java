package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        while(game.getTotalPoints() < 10000) {
            System.out.println("Turn: " + game.getTurnCounter());
            game.takeTurn();
        }

        System.out.print("Total Points: " + game.getTotalPoints() + "\nTotal Turns Taken: " + game.getTurnCounter() + "\nTotal Farkles: " + game.getFarkleCounter());

    }
}
