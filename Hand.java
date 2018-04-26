package com.company;

public class Hand {

    private Dice [] hand;
    int diceCount;

    Hand(){
        this.hand = new Dice [6];
        this.diceCount = 0;
    }

    void fillHand(Dice diceOne, Dice diceTwo, Dice diceThree, Dice diceFour, Dice diceFive, Dice diceSix){
        hand[0] = diceOne;
        hand[1] = diceTwo;
        hand[2] = diceThree;
        hand[3] = diceFour;
        hand[4] = diceFive;
        hand[5] = diceSix;
        diceCount = 5;
    }

    void removeDice(){

        hand[diceCount] = null;
        diceCount--;

    }

    void rollHand(){

        for(int i = 0; i <= diceCount; i++){
            hand[i].randomizeDice();
        }

    }

    void showHand(){

        for(int i = 0; i <= diceCount; i++){
            System.out.println(hand[i].value);
        }
        System.out.println("\n");

    }

    int getHandSize(){

        return diceCount;

    }

    int getDiceValue(int i){

        return hand[i].value;

    }

}
