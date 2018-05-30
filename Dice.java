package com.company;

class Dice implements Runnable {

    int value;

    void randomizeDice(){

        this.value = (int) ((Math.random() * 6) + 1);

    }

    public void run(){
        randomizeDice();
    }

}
