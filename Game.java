package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private int handPoints;
    private int turnPoints;
    private int totalPoints;

    public Game(){
        this.turnPoints = 0;
        this.totalPoints = 0;
    }

    public void takeTurn() throws InterruptedException {

        boolean continueRolling = true;
        boolean farkled = false;
        Hand hand = new Hand();
        turnPoints = 0;

        while(continueRolling && !farkled){
            boolean tookDice = false;
            System.out.println("Rolling Dice...");
            Thread.sleep(1000);
            hand.rollHand();
            hand.showHand();
            ArrayList<int[]> scorableDice = ScorableDiceCreator.createArrayList(hand);
            farkled = hand.checkEmptyHand(scorableDice);
            if(!farkled){
                while(!tookDice){

                    boolean straight = hand.checkStraight(scorableDice);
                    boolean threePair = hand.checkThreePair(scorableDice);
                    boolean twoTriples = hand.checkTwoTriples(scorableDice);
                    boolean sixKind = hand.checkSixKind(scorableDice);

                    if(straight){
                        System.out.println("You rolled a STRAIGHT! \n You've been awarded 1500 points! \n You've been given a new set of six dice to continue rolling for this turn.");
                        turnPoints += 1500;
                        tookDice = true;
                        continueRolling = continueTurn();
                        if(!continueRolling){
                            totalPoints += turnPoints;
                            System.out.println("Points earned this turn: " + turnPoints + ".\nTotal Points: " + totalPoints + ".\nEnding turn...");
                            Thread.sleep(1000);
                            break;
                        }
                    } else if(threePair){
                        System.out.println("You rolled THREE PAIR! \n You've been awarded 1500 points! \n You've been given a new set of six dice to continue rolling for this turn.");
                        turnPoints += 1500;
                        tookDice = true;
                        continueRolling = continueTurn();
                        if(!continueRolling){
                            totalPoints += turnPoints;
                            System.out.println("Points earned this turn: " + turnPoints + ".\nTotal Points: " + totalPoints + ".\nEnding turn...");
                            Thread.sleep(1000);
                            break;
                        }
                    } else if(twoTriples){
                        System.out.println("You rolled TWO TRIPLES! \n You've been awarded 2500 points! \n You've been given a new set of six dice to continue rolling for this turn.");
                        turnPoints += 2500;
                        tookDice = true;
                        continueRolling = continueTurn();
                        if(!continueRolling){
                            totalPoints += turnPoints;
                            System.out.println("Points earned this turn: " + turnPoints + ".\nTotal Points: " + totalPoints + ".\nEnding turn...");
                            Thread.sleep(1000);
                            break;
                        }
                    } else if(sixKind){
                        System.out.println("You rolled TWO TRIPLES! \n You've been awarded 2500 points! \n You've been given a new set of six dice to continue rolling for this turn.");
                        turnPoints += 2500;
                        tookDice = true;
                        continueRolling = continueTurn();
                        if(!continueRolling){
                            totalPoints += turnPoints;
                            System.out.println("Points earned this turn: " + turnPoints + ".\nTotal Points: " + totalPoints + ".\nEnding turn...");
                            Thread.sleep(1000);
                            break;
                        }
                    } else {

                        boolean fiveKind = hand.checkFiveKind(scorableDice);
                        boolean fourKind = hand.checkFourKind(scorableDice);
                        boolean threeKind = hand.checkThreeKind(scorableDice);

                        if(fiveKind){
                            System.out.println("You rolled a Five of a Kind! Points: 2000.");
                            boolean takeDice = takeDiceInquiry();
                            if(takeDice){
                                turnPoints += 2000;
                                tookDice = true;
                                for(int i = 0; i < 5; i++){
                                    hand.removeDice();
                                }
                            }
                            scorableDice.remove(0);
                        } else if(fourKind){
                            System.out.println("You rolled a Four of a Kind! Points: 1500.");
                            boolean takeDice = takeDiceInquiry();
                            if(takeDice){
                                turnPoints += 1500;
                                tookDice = true;
                                for(int i = 0; i < 4; i++){
                                    hand.removeDice();
                                }
                            }
                            scorableDice.remove(0);
                        } else if(threeKind){
                            int amount = scorableDice.get(0)[0] * 100;
                            System.out.println("You rolled Three " + scorableDice.get(0)[0] + "'s! Points: " + amount + ".");
                            boolean takeDice = takeDiceInquiry();
                            if(takeDice){
                                turnPoints += amount;
                                tookDice = true;
                                for(int i = 0; i < 3; i++){
                                    hand.removeDice();
                                }
                            }
                            scorableDice.remove(0);
                        }

                        while((scorableDice.size() > 0) && ((scorableDice.get(0)[0] == 1) || (scorableDice.get(0)[0] == 5))){

                            if(scorableDice.get(0)[0] == 1){
                                System.out.println("You have " + scorableDice.get(0)[1] + " ONES you can take.");
                                int diceCounter = scorableDice.get(0)[1];
                                for(int i = 0; i < diceCounter; i++){
                                    System.out.println("One's remaining: " + scorableDice.get(0)[1] + ".\nA One gives 100 Points.");
                                    boolean takeDice = takeDiceInquiry();
                                    if(takeDice){
                                        turnPoints += 100;
                                        tookDice = true;
                                        hand.removeDice();
                                    }
                                    scorableDice.get(0)[1] -= 1;
                                }
                                scorableDice.remove(0);
                            }

                            if(scorableDice.get(0)[0] == 5){
                                System.out.println("You have " + scorableDice.get(0)[1] + " FIVES you can take.");
                                int diceCounter = scorableDice.get(0)[1];
                                for(int i = 0; i < diceCounter; i++){
                                    System.out.println("Five's remaining: " + scorableDice.get(0)[1] + ".\nA Five gives 50 Points.");
                                    boolean takeDice = takeDiceInquiry();
                                    if(takeDice){
                                        turnPoints += 50;
                                        tookDice = true;
                                        hand.removeDice();
                                    }
                                    scorableDice.get(0)[1] -= 1;
                                }
                                scorableDice.remove(0);
                            }

                        }

                        if(hand.getHandSize() == 0){
                            hand.fillHand();
                            System.out.println("You've scored points with all 6 dice. You've been given a new set of 6 dice to continue rolling for this turn!");
                        }

                        System.out.println("You have scored a total of " + turnPoints + " for this turn.\nYou have " + (hand.getHandSize()+1) + " dice remaining in your hand.");
                        continueRolling = continueTurn();

                        if(!continueRolling){
                            totalPoints += turnPoints;
                            System.out.println("Points earned this turn: " + turnPoints + ".\nTotal Points: " + totalPoints + ".\nEnding turn...");
                            Thread.sleep(1000);
                            break;
                        }

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

    public boolean takeDiceInquiry(){

        Scanner userInput = new Scanner(System.in);
        String answer = "";
        boolean validInput = false;
        boolean takeDice = false;

        System.out.println("Would you like to take the points?");

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
