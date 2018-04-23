package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Hand hand = new Hand();
        Dice diceOne = new Dice();
        Dice diceTwo = new Dice();
        Dice diceThree = new Dice();
        Dice diceFour = new Dice();
        Dice diceFive = new Dice();
        Dice diceSix = new Dice();
        hand.fillHand(diceOne, diceTwo, diceThree, diceFour, diceFive, diceSix);
        hand.rollHand();
        hand.showHand();
        hand.removeDice();
        hand.showHand();



    }
}
