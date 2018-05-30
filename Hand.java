package com.company;

import java.util.ArrayList;

public class Hand {

    private Dice [] hand;
    int diceCount;
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

        for(int i = 0; i <= diceCount-1; i++){
            hand[i].randomizeDice();
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

    public Hand sortHand(Hand hand){
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

    public boolean checkEmptyHand(ArrayList<int[]> scorableDice){

        boolean emptyHand = false;
        if(scorableDice.size() == 0){
            emptyHand = true;
        }

        return emptyHand;

    }

    public boolean checkStraight(ArrayList<int[]> scorableDice){

        boolean straight = false;
        if(scorableDice.size() == 6){
            straight = true;
        }

        return straight;

    }

    public boolean checkThreePair(ArrayList<int[]> scorableDice){

        boolean threePair = false;
        if(scorableDice.size() == 3){
            if((scorableDice.get(0)[1] == 2) && (scorableDice.get(1)[1] == 2) && (scorableDice.get(2)[1] == 2)){
                threePair = true;
            }
        }

        return threePair;
    }

    public boolean checkTwoTriples(ArrayList<int[]> scorableDice){

        boolean twoTriples = false;
        if(scorableDice.size() == 2){
            if((scorableDice.get(0)[1] == 3) && (scorableDice.get(1)[1] == 3)){
                twoTriples = true;
            }
        }

        return twoTriples;

    }

    public boolean checkFourKindWithPair(ArrayList<int[]> scorableDice){

        boolean fourKindWithPair = false;
        if(scorableDice.size() == 2){
            if((scorableDice.get(0)[1] == 4) && (scorableDice.get(1)[1] == 2)){
                fourKindWithPair = true;
            }
        }

        return fourKindWithPair;
    }

    public boolean checkSixKind(ArrayList<int[]> scorableDice){

        boolean sixKind = false;
        if(scorableDice.get(0)[1] == 6){
            sixKind = true;
        }

        return sixKind;

    }

    public boolean checkFiveKind(ArrayList<int[]> scorableDice){

        boolean fiveKind = false;
        if(scorableDice.size() > 0){
            if(scorableDice.get(0)[1] == 5){
                fiveKind = true;
            }
        }

        return fiveKind;

    }

    public boolean checkFourKind(ArrayList<int[]> scorableDice){

        boolean fourKind = false;
        if(scorableDice.size() > 0){
            if(scorableDice.get(0)[1] == 4){
                fourKind = true;
            }
        }

        return fourKind;

    }

    public boolean checkThreeKind(ArrayList<int[]> scorableDice){

        boolean threeKind = false;
        if(scorableDice.size() > 0){
            if(scorableDice.get(0)[1] == 3){
                threeKind = true;
            }
        }

        return threeKind;

    }




}

