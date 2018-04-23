package com.company;

public class Dice {

    int value;

    public void randomizeDice(){

        this.value = (int) ((Math.random() * 6) + 1);

    }

}
