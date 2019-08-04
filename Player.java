/*
   Name: Mark Torres

   Execution: java Player

   Adds players to the PIG game. The API is:

   public class Player
   -------------------------------------------------------------
   Player(String newName)    // creates a new player with name = newName
   int getCurrentScore()     // returns that player's current score
   String getName()          // returns that player's name
   Player getNext()          // get the next player
   void addNewScore()        // adds points to that player's score
   void setNext()            // connects a player to the next player
   void currentScores()      // recursively returns the scores of all the players
   void msgMiddle            // draw a message in the middle of the screen. 

 */

public class Player {
   // Initialize variables
   private int score;
   private String name; 
   private Player next;  

   // Constructors
   public Player(String newName) {
      score = 0; 
      name = newName;
      next = null;
   }

   // Get current score 
   public int getCurrentScore() {
      return this.score;
   }

   // Get name:
   public String getName() {
      return this.name;
   }

   // Get next node
   public Player getNext() {
      return this.next;
   }

   // Set new score
   public void addNewScore(int points) {
      score += points;
   }

   // Set next node
   public void setNext(Player nextPlayer) {
      this.next = nextPlayer;
   }

   // Get the score updates via recursion
   public void currentScores() {
      if (next == null) {
         msgMiddle(0.5, "The score of the last player is: " +
            score + " for " + name);
      } else {
         msgMiddle(0.5, "The score is: " + score + " for " + name);
         next.currentScores(); 
      }
   }
   
   // To set up messages in the middle of the screen
   private static void msgMiddle(double position, String message) {
      PennDraw.text(0.5, position, message);
   }

   // Debugging to make sure it works
   public static void main(String[] args) {
      // Setting up names
      String name1 = args[0];
      String name2 = args[1];

      System.out.println("The first name is: " + name1);
      System.out.println("The second name is: " + name2);

      // Adding new players
      Player newPlayer1 = new Player(name1);

      // Testing getScore
      System.out.println("The score of the first player is: " + 
         newPlayer1.getCurrentScore() + " expected: 0");

      // Testing getName
      System.out.println("The name of the first player is: " +
         newPlayer1.getName() + ". Expected: " + name1);

      // Adding new player
      Player newPlayer2 = new Player(name2);

      // Testing setNext
      newPlayer1.setNext(newPlayer2);

      // Testing getNext
      System.out.println("The name of the second player is: " + 
         newPlayer1.getNext().getName() + " expected: " + name2);

      // After 2 turns, get points
      int newPoints1 = 6;
      int newPoints2 = 8;
      newPlayer1.addNewScore(newPoints1);
      newPlayer2.addNewScore(newPoints2);

      int newPoints3 = 7;
      int newPoints4 = 10;
      newPlayer1.addNewScore(newPoints3);
      newPlayer2.addNewScore(newPoints4);

      System.out.println("The points of the players are: " +
         newPlayer1.getCurrentScore() + " for "  + 
         newPlayer1.getName() + " and " + 
         newPlayer2.getCurrentScore() + " for " + 
         newPlayer2.getName());

      // Get current scores
      newPlayer1.currentScores(); 
   }
}