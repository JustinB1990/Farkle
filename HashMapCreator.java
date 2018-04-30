package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class HashMapCreator {

    public static HashMap<Integer, Integer> createHashMap(Hand hand){

        int[][] results = new int[hand.getHandSize() + 1][2];
        int[] handValues = new int[hand.getHandSize() + 1];
        int[] possibleOutcomes = new int[]{1, 2, 3, 4, 5, 6};
        HashMap<Integer, Integer> scorableDice = new HashMap<Integer, Integer>();
        int arrayTracker = 0;
        for(int i = 0; i < hand.getHandSize(); i++){
            handValues[i] = hand.getDiceValue(i);
        }
        
        for(int i = 0; i < possibleOutcomes.length; i++){
            int counter = 0;
            for(int j = 0; j < hand.getHandSize() + 1; j++){
                if(hand.getDiceValue(j) == possibleOutcomes[i]){
                    counter++;
                }
            }

            if(counter > 0){
                results[arrayTracker][0] = possibleOutcomes[i];
                results[arrayTracker][1] = counter;
                arrayTracker++;
            }
        }

        /*

        The Multidimensional Array was created to have potentially 6 int[] arrays in it. However, when the code doesn't fill all spots of the array, it
        initialized the remaining int[] arrays with zeroes.

         e.g. If the user rolled 1, 1, 2, 2, 3, 3 - the Multidimensional Array would be:
         { [1,2], [2,2], [3,2], [0,0], [0,0], [0,0] }

        In order to properly append items to the HashMap, I would either need to
        remove those [0,0] from the array, or I would need to repeat a bunch of conditional if statements while appending the items to the HashMap.
        I decided to run a quick while loop.

        */

        int loopCounter = 0;
        while(loopCounter < results.length){
            if(results[loopCounter][0] == 0){
                results = Arrays.copyOf(results, results.length - 1);
                loopCounter = 0;
            } else{
                loopCounter++;
            }
        }

        results = orderMultiDimArray(results);

        // check for a straight
        if(results.length == 6){
            for(int i = 0; i < results.length; i++){
                scorableDice.put(results[i][0], results[i][1]);
            }
        }
        // check for 3 pairs
        if(scorableDice.size() == 0){
            if(results.length == 3){
                if((results[0][1] == 2) && (results[1][1] == 2) && (results[2][1] ==2)){
                    scorableDice.put(results[0][0], results[0][1]);
                    scorableDice.put(results[1][0], results[1][1]);
                    scorableDice.put(results[2][0], results[2][1]);
                }
            }
        }
        // check for 4 of a kind with a pair
        if(scorableDice.size() == 0){
            if(results.length == 2){
                if((results[0][1] == 4) && (results[1][1] == 2)){
                    scorableDice.put(results[0][0], results[0][1]);
                    scorableDice.put(results[1][0], results[1][1]);
                }
            }
        }
        // check for 3 of a kind and greater(excluding 1's and 5's, then check for 1's and 5's
        if(scorableDice.size() == 0){

            for(int i = 0; i < results.length; i++){
                if((results[i][0] != 1) && (results[i][0] != 5)){
                    if(results[i][1] > 2){
                        scorableDice.put(results[i][0], results[i][1]);
                    }
                }
            }

            for(int i = 0; i < results.length; i++){
                if(results[i][0] == 1){
                    scorableDice.put(results[i][0], results[i][1]);
                }
                if(results[i][0] == 5){
                    scorableDice.put(results[i][0], results[i][1]);
                }
            }

        }

        return scorableDice;




    }


//Sorts the multi-dimensional array putting highest quantities first.

    public static int[][] orderMultiDimArray(int[][] multiDimArray){
        for(int i=1; i<=multiDimArray.length -1; i++){
            int marker = i;
            int[] currentArray = new int[2];
            currentArray[0] = multiDimArray[i][0];
            currentArray[1] = multiDimArray[i][1];
            int currentValue = multiDimArray[i][1];

            while((marker > 0) && (multiDimArray[marker-1][1] < currentValue)){
                multiDimArray[marker] = multiDimArray[marker-1];
                marker -= 1;
            }

            multiDimArray[marker] = currentArray;
        }

        return multiDimArray;

    }




}
