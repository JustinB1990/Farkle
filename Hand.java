package com.company;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Hand {

    private Dice [] hand;
    private int diceCount;
    private Dice diceOne = new Dice();
    private Dice diceTwo = new Dice();
    private Dice diceThree = new Dice();
    private Dice diceFour = new Dice();
    private Dice diceFive = new Dice();
    private Dice diceSix = new Dice();

    Hand(){
        this.hand = new Dice [6];
        this.diceCount = 0;
        fillHand();
    }

    void fillHand(){
        hand[0] = diceOne;
        hand[1] = diceTwo;
        hand[2] = diceThree;
        hand[3] = diceFour;
        hand[4] = diceFive;
        hand[5] = diceSix;
        diceCount = 6;
    }

    void removeDice(){

        hand[diceCount-1] = null;
        diceCount--;

    }

    void rollHand(){

        ExecutorService es = Executors.newFixedThreadPool(3);
        for(int i = 0; i <= diceCount-1; i++){
            es.submit(hand[i]);
        }

        try {
            es.shutdown();
            es.awaitTermination(5, TimeUnit.SECONDS);
        } catch(Exception e){
            System.out.println("-Error with ES-");
        }

    }

    void showHand(){
        System.out.println("You rolled: ");
        System.out.print("\r");
        for(int i = 0; i <= diceCount-1; i++){
            System.out.print("\b");
            System.out.print("[" + hand[i].value + "]  ");
        }
        System.out.println("\n");

    }

    int getHandSize(){

        return diceCount;

    }

    int getDiceValue(int i){

        return hand[i].value;

    }

    Hand sortHand(Hand hand){
        for(int i = 1; i < diceCount; i++){
            int marker = i;
            Dice currentDice = this.hand[i];
            int currentValue = this.hand[i].value;

            while((marker > 0) && (this.hand[marker-1].value < currentValue)){
                this.hand[marker] = this.hand[marker-1];
                marker -= 1;
            }

            this.hand[marker] = currentDice;
        }

        return hand;
    }

    boolean checkEmptyHand(ArrayList<int[]> scorableDice){

        boolean emptyHand = false;
        if(scorableDice.size() == 0){
            emptyHand = true;
        }

        return emptyHand;

    }

    boolean checkStraight(ArrayList<int[]> scorableDice){

        boolean straight = false;
        if(scorableDice.size() == 6){
            straight = true;
        }

        return straight;

    }

    boolean checkThreePair(ArrayList<int[]> scorableDice){

        boolean threePair = false;
        if(scorableDice.size() == 3){
            if((scorableDice.get(0)[1] == 2) && (scorableDice.get(1)[1] == 2) && (scorableDice.get(2)[1] == 2)){
                threePair = true;
            }
        }

        return threePair;
    }

    boolean checkTwoTriples(ArrayList<int[]> scorableDice){

        boolean twoTriples = false;
        if(scorableDice.size() == 2){
            if((scorableDice.get(0)[1] == 3) && (scorableDice.get(1)[1] == 3)){
                twoTriples = true;
            }
        }

        return twoTriples;

    }

    boolean checkFourKindWithPair(ArrayList<int[]> scorableDice){

        boolean fourKindWithPair = false;
        if(scorableDice.size() == 2){
            if((scorableDice.get(0)[1] == 4) && (scorableDice.get(1)[1] == 2)){
                fourKindWithPair = true;
            }
        }

        return fourKindWithPair;
    }

    boolean checkSixKind(ArrayList<int[]> scorableDice){

        boolean sixKind = false;
        if(scorableDice.get(0)[1] == 6){
            sixKind = true;
        }

        return sixKind;

    }

    boolean checkFiveKind(ArrayList<int[]> scorableDice){

        boolean fiveKind = false;
        if(scorableDice.size() > 0){
            if(scorableDice.get(0)[1] == 5){
                fiveKind = true;
            }
        }

        return fiveKind;

    }

    boolean checkFourKind(ArrayList<int[]> scorableDice){

        boolean fourKind = false;
        if(scorableDice.size() > 0){
            if(scorableDice.get(0)[1] == 4){
                fourKind = true;
            }
        }

        return fourKind;

    }

    boolean checkThreeKind(ArrayList<int[]> scorableDice){

        boolean threeKind = false;
        if(scorableDice.size() > 0){
            if(scorableDice.get(0)[1] == 3){
                threeKind = true;
            }
        }

        return threeKind;

    }




}

