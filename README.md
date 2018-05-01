# Farkle

This project will simulate playing a game of Farkle.

---
#### How Farkle works:

**If you would rather watch a how-to video, I found a decent one [here](https://www.youtube.com/watch?v=PtZlur9Kmb8)**
<details>
  <summary> <b>Written Game Explaination</b> </summary>
  <br>
    Farkle is a turn based gambling game between two or more players that uses six dice.
    Score is kept track from a person's Total Score, and a running score for an individual turn.<br>
    <h3>Game Rules:</h3>
    <ul>
    <li>At the start of the game, in order for any player to retain points in their Total Score, they must have a running score of at   least 500 points for that turn. After obtaining 500 points, for any following turns, they may choose to end their turn no matter how  many points they have scored. (e.g. if they have only scored 200 points, they may choose to end their turn and add those points to their total score.)</li>
    <li>A single turn begins with the active player rolling six dice.</li>
    <li>If at any time, that player rolls a hand that can't score them any points, they have 'Farkled'. Which means that they lose all of the points in that turns running score, and they pass the turn on to another player.</li>
    <li>For each time a player rolls the dice, they must take at least one die or set of dice that would score them points - assuming they didn't Farkle.</li>
    <li>If a player scores points with a die, that die is removed from the hand and won't be re-rolled.</li>
    <li>If all six dice are used to score points, the user may continue the hand with a new set of six dice.</li>
    <li>When a player reaches 10,000 or more points, his or her opponents get one turn each in an attempt to close the gap between their points and that player's.</li>
    </ul>
    <h3>How Scoring Works:</h3>
    <ul>
      <li>A <b>One</b> scores 100 Points.</li>
    <li>A <b>Five</b> scores 50 Points.</li>
    <li>A <b>Three of a kind</b> scores points equal to the number rolled multiplied by 100.
  (e.g. Three 2's score 200 points. Three 5's score 500 points. Three 1's still score 300 points because individual 1's score 100 points each.)</li>
    <li>A <b>Four of a kind</b> scores 1000 Points.</li>
    <li>A <b>Four of a kind</b> with a pair scores 1500 Points.</li>
    <li>A <b>Five of a kind</b> scores 2000 Points.</li>
    <li>A <b>Six of a kind</b> scores 3000 Points.</li>
    <li><b>Two Triples</b> scores 2500 Points.</li>
    <li><b>Three Pairs</b> scores 1500 Points.</li>
    <li>A Straight <b>must</b> include all 6 dice 1-2-3-4-5-6, scores 1500 points.</li>
      </ul>
  <h3>As an example of a single turn in a game:</h3><br>
    The player's total score is currently at 1500. Opponent's total Score is 3150.<br>
    The player rolls 6 Dice and rolls: 2 2 3 4 5 6.<br>
    The player must take the 5 - running score is now 50 points.<br>
    The player rolls 5 Dice: 1 2 2 2 4.<br>
    The player takes a 1, but not the 2's - running score is now 150 points.<br>
    The player rolls 4 Dice: 1 5 6 6.<br>
    The player takes the 1 and the 5 and chooses to end their turn with a running score of 300 points.<br>
    The player's total score is now 1800 and it is their opponent's turn.<br>
    The opponent rolls: 1 1 5 3 3 2.<br>
    The opponent takes both 1's - running score is 200 points.<br>
    The opponent now rolls 4 Dice: 1 2 4 6.<br>
    The opponent must take the 1 - running score is now 300 points.<br>
    The opponent rolls 3 Dice: 2 2 3.<br>
    The opponent Farkled. They lose the 300 points they had. Their Total score of 3150 remains unchanged and it is now 'the Player's turn.
    </details>

---

### Designing the Game

I'm going to begin by designing this game for a single player who will play through a single game of Farkle on their own,
taking turns until they reach 10,000 points. *Then* I will think about adding in a computer for the player to play against.

**What does a game of Farkle look like:**

A player will take turns until they reach 10,000 points. This means there will be a loop that repeats the actions within a Turn that breaks upon the user reaching 10,000 Total Points.

*What happens during a turn:*

A player begins with 6 Dice. They roll the dice over and over until they choose to stop or until they Farkle. 
So a single turn will be a loop of randomizing Dice and allowing our user to select Dice to score points.
The loop breaks when the user chooses to stop or when the user Farkles.

In that loop, the user has to choose dice to take and not take(conditionals - if/else)
and after choosing the dice to score, they need to decide if they want to continue rolling(if/else where the outcome can break the loop.)

**Initial thoughts on how to design Farkle:**

Similar to my Movie Hangman program, I will have a Class for `Game` that holds the user's `totalScore`, `turnScore`, and `rollScore`.
It will also probably have booleans `farkled` and `continueRoll` that will be used as the conditions for the loop I will use to allow the user to roll as many times as they choose(or until they farkle) in a single turn.

Which brings me to the first method in my `Game` class: `Turn`, which holds all of the actions that will take place in a single turn.
I will need a boolean to keep track of whether or not the user took dice for a single roll in a turn.

I will also have a class for `Dice` which will allow me to create Dice Objects. They will have a field `value` that contains a random integer value between 1 and 6. This random integer will be gained from a method within the class that uses `Math.random()`.

Next, I need a way to hold and organize the dice. Class `Hand` will be an Array that will hold the Dice Objects.
I will create methods that will:
* Fill the user's hand with 6 Dice Objects. `newHand`
* Allows me to remove a Dice Object from the Array. `removeDice`
* Allows me to randomize all values of the Dice Objects in the array(effectively rolling a hand of dice.) `rollHand`
* Allows me to display the values of each Dice Object to the user so they know what they rolled. `showHand`

Finally, I need a way to check our hand for 1's, 5's, and the various combo rolls a user can make.
I can make these methods in my `Game` class.

**To start out with:**
In order to do anything at all, I need Dice to work with and a way to organize them.

1. Create a class for `Dice`. Give it a method that allows me to randomize each individual Dice Object's value to an integer between 1 and 6.
2. Create a class for `Hand`. This will be a Dice Array. Create methods: `newHand`, `removeDice`, `rollHand`, `showHand`.

***After this point, it will be more difficult to organize what to program next as I will be digging into actual gameplay. So I will stop at this point to review progress. But I will still list out the next steps I can forsee taking:***

3. Create a method in `Game` that checks the `hand` for 1's and 5's. - Have the method tell the user how many of each there are.
*The other check methods can be implemented at the end. So until then, I am creating a Farkle game in which the only way to score points is through 1's and 5's.*

4. Create the `Turn` method in `Game`. It will use a boolean `keepRolling` and `farkled` as Loop Conditions to make sure the user
wants to keep rolling and hasn't Farkled.

**Inside of that loop:**
  1. The player needs to `rollHand`.
  2. I need to check if the player rolled anything that would score them points.
      * If they didn't then they Farkled and I need to adjust `farkled` to true and exit the loop.
      * If they did, then I need to enter a new loop that's condition is based on a boolean `diceTaken`, which makes sure the user takes **at least** one Dice that would score them points(which I will store in `rollScore`). Inside this loop, I need to ask the user which Dice they want to take and score. as long as `diceTaken` is true, the user can exit the loop(in which case, I will add `rollscore` to `turnScore`.)
       * After exiting the loop, I need to ask if the user wants to keep rolling, or if they want to end their turn.
          * If they want to keep rolling, then they stay in the loop for `Turn` and the loop will restart.
          * If they don't want to keep rolling, then I add `turnScore` to `totalScore`, I check if their `totalScore` has reached 10,000 points, and if it hasn't, I shoot them back into `Turn` to keep playing.

*From here, we have a very basic version of the game we are trying to create - that will allow our user to take turns until they reach 10,000 points. The user will only be able to score points from 1's and 5's. I am going to begin with steps 1 and 2, test them and return to review.*

---
### Progress Report 4/25/2018

I have now created a class for Dice and Hand. I've added the four methods listed above to hand, and I have also added two 'getter' methods for values I found I needed for other methods I have created.

I have also now developed my class `Game` to have points to keep track of my user's score and methods to check the `hand` for 1's and 5's. I've added a method that asks the user if they want to take dice from the `hand` for points - and if so, it will remove the appropriate amount of dice from the `hand`.

I'm currently creating the a method that will act as my user's turn. In order to know if the user wants to continue rolling dice for that turn, I have created a method that will ask the user and return a boolean.

I intend to build on this tomorrow.
New update coming soon.

---

### Update 4/26/2018

I've updated class `Hand` to create the `Dice` objects I will use instead of making everything in `main` - making it cleaner.
I also added a sort method in `Hand` as well.

I created the `takeTurn()` method in `Game` and changed some of the programs outputs to make it more appealing to the eye.

***Next***
* I'm going to create the methods that checks if the user rolled any of the combos.
* Then I will create a method that checks if the user farkled - which will use the other check methods to do so.
* After completing all of those check methods, I can implement them into `takeTurn()`. At that point, the `takeTurn()` method will be able to check for everything a user can score and allow them to score points appropriately for what they roll.
* Then I will create a loop in the `Game` constructor that will loop `takeTurn()` until the player's `totalPoints` reaches 10,000.

---
### Update 4/28/2018

After reviewing options on how to check all of the different outcomes, I decided I am going to create a HashMap that will only ever contain dice that can be used to score points.

Steps to creating the HashMap:
1. Create an Integer Array containing all of the values of dice the user rolls.
2. Create an Integer Array containing possible outcomes the user can roll: [1, 2, 3, 4, 5, 6]
3. Create a 2D Integer Array(`results`), where each Array in `results` will contain 2 integers.
    * The first integer will be the dice value the user rolled.
    * The second integer will be the number of dice that rolled that value.
    * If say, the user didn't roll any 2's, then `results` will not contain an Array where the first value of that array is 2.
  
4. Create conditions over the 2D Array that will add a new key to the HashMap, where the key would be the Dice Value rolled, and the key's value would be the number of dice that rolled that value. **Creating the HashMap to only contain dice that *can* score points**

I believe this will make it easier for me to perform the checks I need each time a player rolls the dice.
Then I can remove dice from `hand` without worrying about it effecting the process of scoring points as it is happening.

---
### Update 4/29/2018

I began creating the HashMap.
I ran into a few problems as I started everything as an Array which has an immutable number of slots.
I figured it would be easier to just use an ArrayList or List, but I wanted to figure out the algorithms needed to overwrite my existing Arrays instead. I also created a sort method that sorts `results` for highest quantity of dice value rolled to least.

At the moment, my multi-dimensional array `results` works and functions exactly as I want it to.
There are some errors in the code to append keys and their values to the HashMap, which I should be able to figure out pretty quickly.

After correcting those errors, I will have to test out the code to make sure that all of the following would be appended to the HashMap:

  * A Straight: 1-2-3-4-5-6.
  * 3 of a kind/ 4 of a kind/ 5 of a kind/ 6 of a kind (with and without lonely 1's and 5's with them.)
  * 4 of a kind with a pair.
  * 3 pairs.
  * 2 Triples.
  * Some combinations of 1's and 5's without any additional combo rolls.
  
The code to append all of these items onto the HashMap is fairly short and uses a couple of if/else conditions and for loops.
  
Upon having a functional HashMap that takes in all of the above,
  
  1. I will need to create the checks that take the hashMap in and returns true/false.
  2. Create the code in `takeTurn` that performs all of those checks.
  3. Create the code asking the user to take or reject points.
  
More updates to come soon!
  
---
### Update 4/30/2018

The HashMapCreator has now been completed.
I've tested it to make sure it takes in all possible combo rolls.

Now I need to create the methods that checks the HashMap for what combo was rolled and return true/false accordingly.
Implement that code into `takeTurn` and test it to make sure they all return the correct boolean when the roll is made.
Then implement the options for the user to take or reject those rolls.

---

 
 
