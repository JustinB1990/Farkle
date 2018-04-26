package com.company;

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
        System.out.println("You rolled: ");
        System.out.print("\r");
        for(int i = 0; i <= diceCount; i++){
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
        for(int i = 1; i < (diceCount+1); i++){
            int marker = i;
            Dice currentDice = this.hand[i];
            int currentValue = this.hand[i].value;

            while((marker > 0) && (this.hand[marker-1].value > currentValue)){
                this.hand[marker] = this.hand[marker-1];
                marker -= 1;
            }

            this.hand[marker] = currentDice;
        }

        return hand;
    }

}
