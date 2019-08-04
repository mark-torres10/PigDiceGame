/*
   Name: Mark Torres

   Execution: java Game

   Executes the actual PIG game. The API is:

   public class Game
   -------------------------------------------------------------
   Game(String[] names)          // creates a new PIG game with array of names
   void insertFirstPlayer()      // adds the first player to the game
   void insertNextPlayer()       // adds the next player to the game
   void getFirstPlayer()         // returns the first player
   void setWinThreshold()        // sets the win threshold
   int getWinThreshold()         // returns the win threshold 
   int getHighestScore()         // returns highest score
   String getHighestScoreName()  // returns  name of player with highest score  
   void highestScoreUpdate()     // updates the highest score after each round
   void msgMiddle                // draw a message in the middle of the screen. 

 */

public class Game {
   // Initialize parameters 
   private static Player firstPlayer; 
   private static Player endPlayer; // Last player
   private int winThreshold = 100; // Win condition
   private int highestScore = 0; // Highest current score
   private String highestScoreName = ""; 
   private int turnCount = 0; // Initialize number of turns

   // Constructor
   public Game(String[] names) {
      if (names.length < 4) {
         System.out.println("You need 4 players to play this game!"); 
      }
      // Add players 
      for (int i = 0; i < 4; i++) {
         if (i == 0) {
            Player player1 = new Player(names[0]);
            insertFirstPlayer(player1);
         }
         else {
            Player newPlayer = new Player(names[i]);
            insertNewPlayer(newPlayer);
         }
      }
   }

   // To insert first player
   public void insertFirstPlayer(Player player1) {
      // Set up first and last player
      firstPlayer = player1;
      endPlayer = player1;
   }

   // To insert new player
   public void insertNewPlayer(Player newPlayer) {
      
      // Connect after last player
      endPlayer.setNext(newPlayer);

      endPlayer = newPlayer; 
   }

   // To get the first player
   public Player getFirstPlayer() {
      return firstPlayer; 
   }

   public void setWinThreshold(int n) {
      this.winThreshold = n; 
   }
   
   // Get highest score
   public int getHighestScore() {
      return highestScore; 
   }
   
   // Get name of highest score
   public String getHighestScoreName() {
      return highestScoreName; 
   }

   public int getWinThreshold() {
      return this.winThreshold; 
   }
   // To set up messages in the middle of the screen
   private static void msgMiddle(double position, String message) {
      // Clear previous screen
      PennDraw.clear(); 
      // Write message
      PennDraw.text(0.5, position, message);
   }

   
   // Update the highest score
   public void highestScoreUpdate() {
      // Initialize variables
      int highScore = 0; 
      String highScoreName = ""; 
      // Iterate to see who has the highest score
      for (Player p = firstPlayer; p != null; p = p.getNext()) {
         if (p.getCurrentScore() > highScore) {
            highScore = p.getCurrentScore(); 
            highScoreName = p.getName(); 
         }
      }
      // Update the highest score
      this.highestScore = highScore; 
      this.highestScoreName = highScoreName; 
   }
   
   public static void main(String[] args) {
      /*// Testing functions
      // Creating a new game
      String[] names = new String[4];  // Create new array
      // Show message if not enough players
      if (args.length < 4) {
         System.out.println("You need 4 players to play this game!"); 
      }
      // Initialize game
      for (int i = 0; i < 4; i++) {
         names[i] = args[i]; 
         System.out.println(names[i]); 
      }

      Game newGame = new Game(names); 

      // Get the names of all the players:
      for (Player p = firstPlayer; p != null; p = p.getNext()) {
         System.out.println(p.getName()); 
      }

      // Test getters:
      System.out.println(newGame.isThereWinner() + ", expected = FALSE"); 
      System.out.println(newGame.getHighestScore() + ", expected = 0"); 
      System.out.println(newGame.getHighestScoreName() + ", expected = '' ");

      // Testing score updates:
      firstPlayer.addNewScore(6); 
      System.out.println(firstPlayer.getCurrentScore() + " expected: 6");
      newGame.highestScoreUpdate(); 


      */
      // Now to see if we can implement the game:
      // First, I'll do a trial run

      /*int turnCount = newGame.getTurnCount(); 
      while(turnCount < 3) {
         turnCount++; 
         for(Player p = firstPlayer; p != null; p = p.getNext()) {
            // Do a roll, get the score
            int roll = p.turn(); 
            // Message
            if (roll == 0) {
               //msgMiddle(0.5, "Sorry, but you rolled a 1. Now your turn is over");

            }
            else {
               //msgMiddle(0.5, "You rolled a " + roll);
               System.out.println("You rolled a " + roll); 
            }
            // Update score
            p.addNewScore(roll); 
         }
      }*/
      /*
      newGame.highestScoreUpdate(); 
      System.out.println("The current high score is " + 
         newGame.getHighestScore() + " by " + 
         newGame.getHighestScoreName()); 

      // Now, iterate it until someone has reached some threshold:

      newGame.setWinThreshold(100); 

      while (newGame.getHighestScore() < newGame.getWinThreshold()) {
         for (Player p = firstPlayer; p != null; p = p.getNext()) {
            // Do a roll, get the score
            int roll = p.turn(); 
            // Message
            if (roll == 0) {
               msgMiddle(0.5, "Sorry, but you rolled a 1. Now your turn is over");

            }
            else {
               //msgMiddle(0.5, "You rolled a " + roll);
               System.out.println("You rolled a " + roll); 
            }
            // Update score
            p.addNewScore(roll); 
         }
         // Get highest score update
         newGame.highestScoreUpdate(); 
      }

      newGame.highestScoreUpdate(); 
      System.out.println("The current high score is " + 
         newGame.getHighestScore() + " by " + 
         newGame.getHighestScoreName()); 
      */
     /*while(!isThereWinner) { // While nobody has won yet
         // Keep track of the number of turns:
         turnCounter++; 

         // Message to player 1 to roll
         msgMiddle(0.5, "Now it's your turn to roll!"); 
         msgMiddle(0.4, "Press 'r' to roll!"); 

         // 

      }*/
      /*// ACTUAL SETUP: 
      // Set up players
      String[] playerNames = new String[4];
      
      // Fill in the names of the players 
      for (int i = 0; i < 4; i++) {
         playerNames[i] = args[i]; 
      }
      
      // Initialize game
      Game game = new Game(playerNames); 

      // Set up games
      while(!game.isThereWinner()) {
         // Do the turn
         game.turn(); 
         // Update the highest score
         game.highestCurrentScore(); 
      }

      // Declare the winner:
      
      // If the human player won
      if (firstPlayer.getName() == game.getHighestScoreName()) {
         msgMiddle(0.5, "Congratulations! You won!"); 
         msgMiddle(0.3, "You had a final score of: " + game.getHighestScore()); 
      }
      // If the artificial players won
      else {
         msgMiddle(0.5, "Unfortunately, you lost! The winner was " + 
            game.getHighestScoreName()); 
         msgMiddle(0.4, "with a score of " + game.getHighestScore()); 
      }*/
   }
}