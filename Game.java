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

    public void takeTurn(){



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

            if(answer.equals("Y")){
                validInput = true;
                continueTurn = true;
            } else if(answer.equals("N")){
                validInput = true;
            } else {
                System.out.println("You did not give a valid input.");
            }
        }

        return continueTurn;

    }

    public void checkOnesAndFives(Hand hand){

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

        System.out.println("Would you like to take a:" + diceValue + " for " + diceScore + " points?");

        while(!validInput){

            System.out.println("Please enter 'Y' or 'N'.");
            answer = userInput.next();

            if(answer.equals("Y")){
                takeDice = true;
                validInput = true;
            } else if(answer.equals("N")){
                validInput = true;
            } else {
                System.out.println("You did not give a valid input.");
            }

        }

        return takeDice;

    }

}
