# Farkle

This project will simulate playing a game of Farkle.

---
#### How Farkle works:

**If you would rather watch a how-to video, I found a decent one [here](https://www.youtube.com/watch?v=PtZlur9Kmb8)**
<details>
  <summary> **Written game explaination here** </summary>
  <br>
    Farkle is a turn based gambling game between two or more players that uses six dice.
    Score is kept track from a person's Total Score, and a running score for an individual turn.

    #### Game Rules:

    * At the start of the game, in order for any player to retain points in their Total Score, they must have a running score of at   least 500 points for that turn. After obtaining 500 points, for any following turns, they may choose to end their turn no matter how  many points they have scored. (e.g. if they have only scored 200 points, they may choose to end their turn and add those points to their total score.)
    * A single turn begins with the active player rolling six dice.
    * If at any time, that player rolls a hand that can't score them any points, they have 'Farkled'. Which means that they lose all of the points in that turns running score, and they pass the turn on to another player.
    * For each time a player rolls the dice, they must take at least one die or set of dice that would score them points - assuming they didn't Farkle.
    * If a player scores points with a die, that die is removed from the hand and won't be re-rolled.
    * If all six dice are used to score points, the user may continue the hand with a new set of six dice.
    * When a player reaches 10,000 or more points, his or her opponents get one turn each in an attempt to close the gap between their points and that player's.

    ##### How Scoring Works:

    * A One scores 100 Points.
    * A Five scores 50 Points.
    * A Three of a kind scores points equal to the number rolled multiplied by 100.
  (e.g. Three 2's score 200 points. Three 5's score 500 points. Three 1's still score 300 points because individual 1's score 100 points each.)
    * A Four of a kind scores 1000 Points.
    * A Four of a kind with a pair scores 1500 Points.
    * A Five of a kind scores 2000 Points.
    * A Six of a kind scores 3000 Points.
    * Two Triples scores 2500 Points.
    * Three Pairs scores 1500 Points.
    * A Straight must include all 6 dice 1-2-3-4-5-6, scores 1500 points.

    ##### As an example of a single turn in a game:
    The player's total score is currently at 1500. Opponent's total Score is 3150.
    The player rolls 6 Dice and rolls: 2 2 3 4 5 6
    The player must take the 5 - running score is now 50 points.
    The player rolls 5 Dice: 1 2 2 2 4
    The player takes a 1, but not the 2's - running score is now 150 points.
    The player rolls 4 Dice: 1 5 6 6
    The player takes the 1 and the 5 and chooses to end their turn with a running score of 300 points.
    The player's total score is now 1800 and it is their opponent's turn.

    The opponent rolls: 1 1 5 3 3 2
    The opponent takes both 1's - running score is 200 points.
    The opponent now rolls 4 Dice: 1 2 4 6
    The opponent must take the 1 - runninf score now 300 points.
    The opponent rolls 3 Dice: 2 2 3
    The opponent Farkled. They lose the 300 points they had. Their Total score of 3150 remains unchanged and it is now 'the Player's turn.
    <details>

---
