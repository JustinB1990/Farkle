package com.company;

class Dice {

    int value;

    void randomizeDice(){

        this.value = (int) ((Math.random() * 6) + 1);

    }

}
