package com.company;

import java.util.Scanner;

public class Game {

    private int handPoints;
    private int turnPoints;
    private int totalPoints;

    public Game(){
        this.handPoints = 0;
        this.turnPoints = 0;
        this.totalPoints = 0;
    }

    public void takeTurn() throws InterruptedException {

        boolean continueRolling = true;
        boolean farkled = false;
        Hand hand = new Hand();

        while(continueRolling && !farkled){
            boolean tookDice = false;
            System.out.println("Rolling Dice...");
            Thread.sleep(1000);
            hand.rollHand();
            if(!farkled){
                while(!tookDice){
                    int handCount = hand.getHandSize();
                    hand = hand.sortHand(hand);
                    hand.showHand();
                    askForOnesAndFives(hand);
                    turnPoints += handPoints;
                    if(handCount == hand.getHandSize()){
                        System.out.println("You didn't take any dice. You must take at least one.\n");
                    } else {
                        System.out.println("You have " + (hand.getHandSize()+1) + " dice remaining in hand for this turn and you've scored " + turnPoints + " points so far this turn.");
                        continueRolling = continueTurn();
                        tookDice = true;
                    }
                }
            } else {
                System.out.println("You Farkled. No points awarded this turn.");
                turnPoints = 0;
            }

        }

    }

    public boolean continueTurn(){

        Scanner userInput = new Scanner(System.in);
        String answer = "";
        boolean validInput = false;
        boolean continueTurn = false;

        System.out.println("Would you like to continue rolling for this turn?");
        while(!validInput){
            System.out.println("Please enter 'Y' or 'N'.");
            answer = userInput.next();

            if(answer.equals("Y") || answer.equals("y")){
                validInput = true;
                continueTurn = true;
            } else if(answer.equals("N") || answer.equals("n")){
                validInput = true;
            } else {
                System.out.println("You did not give a valid input.");
            }
        }

        return continueTurn;

    }

    public void askForOnesAndFives(Hand hand){

        int diceToRemove = 0;

        for(int j = 0; j < hand.getHandSize()+1; j++){

            boolean userAnswer = false;

            if(hand.getDiceValue(j) == 1) {
                userAnswer = takeDiceInquiry(1, 100);
                if (userAnswer) {
                    diceToRemove++;
                    handPoints += 100;
                }
            }

            if(hand.getDiceValue(j) == 5) {
                userAnswer = takeDiceInquiry(5,50);
                if(userAnswer) {
                    diceToRemove++;
                    handPoints += 50;
                }

            }

        }

        for(int k = 0; k < diceToRemove; k++){
            hand.removeDice();
        }

    }



    public boolean takeDiceInquiry(int diceValue, int diceScore){

        Scanner userInput = new Scanner(System.in);
        String answer = "";
        boolean validInput = false;
        boolean takeDice = false;

        System.out.println("Would you like to take a: " + diceValue + " for " + diceScore + " points?");

        while(!validInput){

            System.out.println("Please enter 'Y' or 'N'.");
            answer = userInput.next();

            if(answer.equals("Y") || answer.equals("y")){
                takeDice = true;
                validInput = true;
            } else if(answer.equals("N") || answer.equals("n")){
                validInput = true;
            } else {
                System.out.println("You did not give a valid input.");
            }

        }

        return takeDice;

    }




}
