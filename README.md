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
    The opponent must take the 1 - runninf score now 300 points.<br>
    The opponent rolls 3 Dice: 2 2 3.<br>
    The opponent Farkled. They lose the 300 points they had. Their Total score of 3150 remains unchanged and it is now 'the Player's turn.
    </details>

---

### Designing the Game

**Initial thoughts on how to design Farkle:**

Similar to that of the HangMan game, I'm going to create a class **Game** that will keep track of our user's *Total Score* and *Turn Score*. It will also contain methods such as *Taking a single turn* and *determining if the user has reached 10,000 points*.

In addition to class **Game** I think we should have classes for:

**Dice** - Which will allow us to create Dice objects. We will have a method that assigns a Dice Object an integer value between 1 and 6.

**Hand** - Which will allow us to create an ArrayList that contains our Dice objects. It will have methods to add and remove Dice Objects from the ArrayList, effectively acting as our user's hand as they roll the dice. It will also have methods that will re-randomize the Dice Object's values in the array and a method that will display what those values are.

I haven't decided if **Scoreboard** will be a Class as well or if I will just include the methods in our **Game** class,
but we need methods that will take in our ArrayList of Dice Objects and check to see if our user rolled any special combos.

So to begin with:

**Step 1:** Create a class for Dice. Give it a method that randomizes it's value to an integer between 1 and 6. [ *test code* ]

**Step 2:** Create a class for Hand that holds an ArrayList containing object type Dice.
 * Give it a method to show/print the values of each Dice object in the ArrayList. [ *test code*  ]
 * Give it a method to add a number of Dice objects to the ArrayList. [ *test code* ]
 * Give it a method to remove a number of Dice objects from the ArrayList. [ *test code* ]
 * Give it a method to randomize all values of the Dice objects in the ArrayList. [ *test code* ]
 
 At this point we will have:
 * The Dice our user will roll.
 * The ability to have our user begin a new hand with 6 dice.
 * The ability to have our user roll the dice and remove dice they should no longer roll.
 
 **Step 3:** Next, we should create a method that checks for 1's and 5's being *rolled* - and see if our program recognizes when this occurs. [ *test code* ]
 
 If this does work. I think I will push creating the rest of the check methods(like seeing if our user rolled a *4 of a kind*) to the end.
 
 **Step 4:** I think the next task is to allow our user to interact with the game. The next step is to work Scanner into the program: Ask our user if they want to take a 1 or a 5. If they say Yes, remove that Dice Object from the hand. If they say No, leave it. [ *test code*]
 
 *I think this is a good place stop. I'll come back to this once I complete **Step 2***.
 
 
