# Pig Dice Game
Java implementation of the Pig dice game (link: https://en.wikipedia.org/wiki/Pig_(dice_game))

The rules, as per Wikipedia (see above link) are: 

Each turn, a player repeatedly rolls a dice until either a 1 is rolled or the player decides to "hold":

If the player rolls a 1, they score nothing and it becomes the next player's turn.
If the player rolls any other number, it is added to their turn total and the player's turn continues.
If a player chooses to "hold", their turn total is added to their score, and it becomes the next player's turn.
The first player to score 100 or more points wins.

Within the repository are 4 scripts:

1. Main.java: implements interactive game.
2. Game.java: implements one iteration of the Pig game, is called in Main.java to implement full game
3. Player.java: creates individual players for game
4. Dice.java: creates dice object
