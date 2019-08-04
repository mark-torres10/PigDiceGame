/*
   Name: Mark Torres

   Execution: java Main

   Executes the entire, interactive PIG game, from start to finish. 

 */

public class Main {
   // Initialize key that is being pressed
   private static char key;

   // Helper methods
   private static void msgLeft(double position, String message) {
      // Clear previous screen
      PennDraw.clear(); 
      // Write message
      PennDraw.text(0.35, position, message);
   }

   private static void msgMiddle(double position, String message) {
      // Clear previous screen
      PennDraw.clear(); 
      // Write message
      PennDraw.text(0.5, position, message);
   }

   private static void msgRight(double position, String message) {
      // Clear previous screen
      PennDraw.clear(); 
      // Write message
      PennDraw.text(0.65, position, message);
   }   

   public static void main(String[] args) {
      // (1) Show welcome screen
      // Write things on screen
      PennDraw.setPenRadius(0.5); 
      msgMiddle(0.5, "Welcome to the PIG game!"); 
      PennDraw.text(0.5, 0.4, "Please press 'f' to continue to the next page");
      // Key detection
      while (key != 'f') {
         // make sure there is keyboard input to process
         if (PennDraw.hasNextKeyTyped()) { 
             // read in one character of keyboard input
            key = PennDraw.nextKeyTyped(); 
         }
      }

      // (2) Ask for names
      // (2a) Ask for how many letters are in their name
      if (key == 'f') {
         // Clear the screen
         msgMiddle(0.5, "Before we start, how many letters are in your name?"); 
      }

      // Get number of letters in name
      char n = '\u0000'; 
      while (n == '\u0000') {
         if (PennDraw.hasNextKeyTyped()) {
            n = PennDraw.nextKeyTyped(); 
         }
      }

      int number = Character.getNumericValue(n); 
      msgMiddle(0.5, "Ok, so there are " + number + 
         " letters in your name. What is your name?"); 
      PennDraw.text(0.5, 0.4, "Please don't misspell your name:");
      PennDraw.text(0.5, 0.3, "I'll include a delete functionality in the future!");

      // (2b) Ask for their name
      String[] names = new String[4]; 

      // Get letters of name
      String name1 = ""; 
      for (int i = 0; i < number; i++) {
         char letter = '\u0000';
         while (letter == '\u0000') {
            if (PennDraw.hasNextKeyTyped()) {
               letter = PennDraw.nextKeyTyped(); 
            }
         }
         name1 += letter; 
      }
      names[0] = name1; 

      // New message
      msgMiddle(0.5, "So, your name is " + names[0]);
      PennDraw.text(0.5, 0.4, "Great to meet you!"); 
      PennDraw.text(0.5, 0.3, "Please press 'f' to continue to the next page");

      // New message
      key = '\u0000'; 

      // Key detection
      while (key != 'f') {
         // make sure there is keyboard input to process
         if (PennDraw.hasNextKeyTyped()) {  
            // read in one character of keyboard input
            key = PennDraw.nextKeyTyped();  
         }
      }

      msgMiddle(0.5, "Now, in this game there are 4 players total"); 
      PennDraw.text(0.5, 0.4, "What would you like to name the other players?"); 
      PennDraw.text(0.5, 0.3, "Let's start with Player 2");
      PennDraw.text(0.5, 0.2, "Please press 'f' to continue to the next page");  

      // New message
      key = '\u0000'; 

      // Key detection
      while (key != 'f') {
         // make sure there is keyboard input to process
         if (PennDraw.hasNextKeyTyped()) {  
            // read in one character of keyboard input
            key = PennDraw.nextKeyTyped();  
         }
      }
       
      // (2c) Ask for names of other players

      for (int i = 0; i < 3; i++) {
         // Ask how many letters are in their name
         msgMiddle(0.5, "How many letters are in the name of Player " + 
            (i + 2) + "?"); 
         
         n = '\u0000'; 
         while (n == '\u0000') {
            if (PennDraw.hasNextKeyTyped()) {
               n = PennDraw.nextKeyTyped(); 
            }
         }
         number = Character.getNumericValue(n); 
         // Get name
         msgMiddle(0.5, "Great! So Player " + (i + 2) + " has " + number + 
            " letters in their name. What's their name?"); 

         // Get letters typed in the name
         String newName = ""; 
         for (int j = 0; j < number; j++) {
            char letter = '\u0000';
            while (letter == '\u0000') {
               if (PennDraw.hasNextKeyTyped()) {
                  letter = PennDraw.nextKeyTyped(); 
               }
            }
            newName += letter; 
         }
         names[i + 1] = newName; 
      }
      // (2d) Announce the names of all the players
      msgLeft(0.75, "Great! So the players in this game are:"); 
      for (int i = 0; i < 4; i++) {
         PennDraw.text(0.5, 0.5 - (i * 0.1), "Player " + (i + 1) + ": " + names[i]); 
      }

      // (3) Announce the rules of the game
      PennDraw.text(0.5, 0.05, "Please press 'f' to continue to the next page");

      // New message
      key = '\u0000'; 

      // Key detection
      while (key != 'f') {
         // make sure there is keyboard input to process
         if (PennDraw.hasNextKeyTyped()) {  
            // read in one character of keyboard input
            key = PennDraw.nextKeyTyped();  
         }
      }

      if (key == 'f') {
         msgMiddle(0.7, "Now, here are the rules to the game:"); 
         PennDraw.text(0.5, 0.6, "1. During each turn, each player rolls a dice"); 
         PennDraw.text(0.5, 0.55, "2. If a player rolls a 1, they get no points");
         PennDraw.text(0.5, 0.5, "for the round and their turn ends"); 
         PennDraw.text(0.5, 0.45, "2. If a player rolls anything else, that gets");
         PennDraw.text(0.5, 0.4, "added to their turn total, and they can go again");
         PennDraw.text(0.5, 0.35, "3. After each player has rolled their dice, ");
         PennDraw.text(0.5, 0.3, "the turn ends, and we'll get a score update");
         PennDraw.text(0.5, 0.25, "4. The game continues until");
         PennDraw.text(0.5, 0.2, "someone gets 100 points!"); 
         PennDraw.text(0.5, 0.1, "Got it? Good luck! Press 's' to start!");
      }    

      // (4) Start the game!
      while (key != 's') {
         // make sure there is keyboard input to process
         if (PennDraw.hasNextKeyTyped()) { 
            // read in one character of keyboard input
            key = PennDraw.nextKeyTyped(); 
         }
      }

      if (key == 's') {
         msgMiddle(0.5, "Let's start this game! You'll be up first, "); 
         PennDraw.text(0.5, 0.4, "and then the other players will go"); 
         PennDraw.text(0.5, 0.3, "Press 'f' to continue"); 
      }

      key = '\u0000'; 

      // Key detection
      while (key != 'f') {
         // make sure there is keyboard input to process
         if (PennDraw.hasNextKeyTyped()) {  
            // read in one character of keyboard input
            key = PennDraw.nextKeyTyped();  
         }
      }

      // Initialize new game
      Game newGame = new Game(names);
   
      // firstPlayer = human Player. secondPlayer = first AI player

      Player firstPlayer = newGame.getFirstPlayer(); 

      // Initialize parameters
      int threshold = newGame.getWinThreshold(); 
      int highestScore = newGame.getHighestScore(); 
      int turnCount = 0; 

      // NOW TO ACTUALLY PLAY THE GAME
      while (highestScore < threshold) {
         // Increase turn count
         turnCount++; 

         // Welcome screen:
         msgMiddle(0.5, "Welcome to Round " + turnCount); 
         PennDraw.text(0.5, 0.4, "Press 'f' to continue"); 
         key = '\u0000'; 
         while (key != 'f') {
            // make sure there is keyboard input to process
            if (PennDraw.hasNextKeyTyped()) {  
               // read in one character of keyboard input
               key = PennDraw.nextKeyTyped();  
            }
         }

         // Initialize points this turn. Put points into here
         int[] pointsThisTurn = new int[4]; 

         // Start with human player
         boolean turnContinue = true; 
         int temporaryScore = 0;

         // (1) Use while loop for a given human turn
         OUTER_LOOP:
         while (turnContinue) { 
            // Message to roll
            msgMiddle(0.5, "Now it's your turn to roll! Press 'r' to roll"); 
            // Detect input, then roll dice
            // New message
            key = '\u0000'; 

            // Key detection
            while (key != 'r') {
               // make sure there is keyboard input to process
               if (PennDraw.hasNextKeyTyped()) {
                  // read in one character of keyboard input
                  key = PennDraw.nextKeyTyped();  
               }
            }
            // Roll the dice
            
            int roll; 
            roll = Dice.roll();

            // Evaluate based on the value of the dice
            if (roll == 1) {
               msgMiddle(0.5, "Oh no! You rolled a 1." + 
                  "Your turn is over and you get 0 points"); 
               temporaryScore = 0;  
               PennDraw.text(0.5, 0.4, "Now it's the next player's turn." + 
                  "Press 'f' to continue");
               while (key != 'f') {
                  // make sure there is keyboard input to process
                  if (PennDraw.hasNextKeyTyped()) {  
                     // read in one character of keyboard input
                     key = PennDraw.nextKeyTyped();
                  }
               } 
               if (key == 'f') {
                  turnContinue = false;
                  break OUTER_LOOP; 
               }
            } 
            if (roll != 1) {
               // Update temporary score
               temporaryScore += roll; 
               msgMiddle(0.5, "Congrats! You rolled a " + roll); 
               PennDraw.text(0.5, 0.4, "Would you like to roll again?"); 
               PennDraw.text(0.5, 0.3, "Press 'y' if yes, 'n' if no"); 

               // Give chance to roll again
               char rollKey = '\u0000'; 
               while (rollKey != 'y' && rollKey != 'n') {
                  // make sure there is keyboard input to process
                  if (PennDraw.hasNextKeyTyped()) { 
                     // read in one character of keyboard input
                     rollKey = PennDraw.nextKeyTyped();  
                  }
               }
               // Option if yes
               if (rollKey == 'y') {
                  turnContinue = true; 
               }

               // Option if no
               if (rollKey == 'n') { // If they say no, end the turn
                  // end turn
                  pointsThisTurn[0] = temporaryScore; 
                  msgMiddle(0.5, "You got " + 
                     pointsThisTurn[0] + " points this round."); 
                  PennDraw.text(0.5, 0.4, "Now it's the next player's turn." + 
                     "Press 'f' to continue");
                  while (key != 'f') {
                     // make sure there is keyboard input to process
                     if (PennDraw.hasNextKeyTyped()) { 
                     // read in one character of keyboard input
                        key = PennDraw.nextKeyTyped();  
                     }
                  } 
                  if (key == 'f') {
                     turnContinue = false;
                     break OUTER_LOOP; 
                  }
               }
            }
         }

         // (2) Now to do the AI turns
         for (int i = 1; i < 4; i++) {
            // Message
            msgMiddle(0.5, "Now it's Player " + (i + 1) + "'s turn to go"); 
            PennDraw.text(0.5, 0.4, "Press 's' to continue"); 
            while (key != 's') {
               // make sure there is keyboard input to process
               if (PennDraw.hasNextKeyTyped()) { 
                  // read in one character of keyboard input
                  key = PennDraw.nextKeyTyped();  
               }
            }

            
            // Initialize variables
            int temporaryScoreAI = 0; 
            boolean aiContinue = true;
            while (aiContinue) {
               int aiRoll = Dice.roll(); 
               if (aiRoll == 1) {
                  temporaryScoreAI = 0; 
                  aiContinue = false; 
               } else {
                  // Add roll to temporaryScore
                  temporaryScoreAI += aiRoll; 
                  // Continue rolling with 50% probability
                  if (Math.random() > 0.5) {
                     aiContinue = true; 
                  } else {
                     aiContinue = false; 
                  }
               }
            }
            // Add temporary AI scores to the points this turn
            pointsThisTurn[i] = temporaryScoreAI; 
            // Set temporary AI scores as well?

            // Show what the AI got
            msgMiddle(0.5, "This round, Player " + (i + 1) + 
               " got " + pointsThisTurn[i] + " points"); 
            PennDraw.text(0.5, 0.4, "Press 'f' to continue to the next player"); 
            while (key != 'f') {
               // make sure there is keyboard input to process
               if (PennDraw.hasNextKeyTyped()) {  
                  // read in one character of keyboard input
                  key = PennDraw.nextKeyTyped();  
               }
            }
         }

         // (3) Now do score updates
         msgMiddle(0.5, "Now, we'll do the score updates. Press 'f' to continue"); 
         key = '\u0000'; 
         while (key != 'f') {
            // make sure there is keyboard input to process
            if (PennDraw.hasNextKeyTyped()) {  
               // read in one character of keyboard input
               key = PennDraw.nextKeyTyped();  
            }
         }

         int index = 0; 
         for (Player p = firstPlayer; p != null; p = p.getNext()) {
            p.addNewScore(pointsThisTurn[index]); 
            index++; 
         }

         // (4) Now to get the highest score updates
         newGame.highestScoreUpdate(); 
         highestScore = newGame.getHighestScore(); 

         // (5) Announce updates
         msgMiddle(0.7, "Now, to announce the points:"); 
         int k = 0; 
         for (Player p = firstPlayer; p != null; p = p.getNext()) {
            int score = p.getCurrentScore(); 
            String name = p.getName(); 
            PennDraw.text(0.35, 0.5 - (0.08 * k), name); 
            PennDraw.text(0.65, 0.5 - (0.08 * k), Integer.toString(score)); 
            k++; 
         }

         // Checking for ties
         int numTies = 0;
         String nameTies = ""; 

         for (Player p = firstPlayer; p != null; p = p.getNext()) {
            int numPointsP = p.getCurrentScore(); 
            for (Player q = p.getNext(); q != null; q = q.getNext()) {
               int numPointsQ = q.getCurrentScore(); 
               if (numPointsP == numPointsQ && numPointsP == highestScore) {
                  // Increase number of ties
                  numTies++; 
                  // If  name is already in string of names, don't add twice
                  if (nameTies.contains(p.getName())) {
                     nameTies = nameTies + " and " + q.getName(); 
                  } else {
                     nameTies = nameTies + p.getName() + " and " + q.getName(); 
                  } 
               }
            }
         }
         // Message after the rounds
         if (numTies != 0) {
            PennDraw.text(0.5, 0.15, "Currently, " + nameTies + 
               " are tied for the lead with " + 
               newGame.getHighestScore() + "points!");
            PennDraw.text(0.5, 0.1, "Press 'f' to continue");  
         } else {
            PennDraw.text(0.5, 0.15, "Currently, " + newGame.getHighestScoreName() + 
               " is in the lead with " + 
               newGame.getHighestScore() + " points!"); 
            PennDraw.text(0.5, 0.1, "Press 'f' to continue"); 
         }

         key = '\u0000'; 
         while (key != 'f') {
            // make sure there is keyboard input to process
            if (PennDraw.hasNextKeyTyped()) {
               // read in one character of keyboard input
               key = PennDraw.nextKeyTyped();  
            }
         }
      }
      // (5) NOW, TO SEE WHO WON AT THE END OF THE GAME
      // Checking to see if there are any ties at the end
      int endgameTiesCount = 0; 
      String endgameTies = ""; 
      for (Player p = firstPlayer; p != null; p = p.getNext()) {
         int numPointsP = p.getCurrentScore(); 
         for (Player q = p.getNext(); q != null; q = q.getNext()) {
            int numPointsQ = q.getCurrentScore(); 
            if (numPointsP == numPointsQ && 
               numPointsP == newGame.getHighestScore()) {
               // Increase number of ties
               endgameTiesCount++; 
               // If  name is already in string of names, don't add twice
               if (endgameTies.contains(p.getName())) {
                  endgameTies = endgameTies + " and " + q.getName(); 
               } else {
                  endgameTies = endgameTies + p.getName() + " and " + q.getName(); 
               } 
            }
         }
      }

      // Now displaying the output message
      msgMiddle(0.5, "Now, the game is over. Let's see who won!"); 
      PennDraw.text(0.5, 0.4, "Press 'f' to continue"); 
      while (key != 'f') {
         // make sure there is keyboard input to process
         if (PennDraw.hasNextKeyTyped()) {  
            // read in one character of keyboard input
            key = PennDraw.nextKeyTyped();  
         }
      }
      if (endgameTiesCount != 0) {
         msgMiddle(0.5, "We had a tie! The winners are: "); 
         PennDraw.text(0.5, 0.4, endgameTies); 
      } else {
         msgMiddle(0.5, "The winner is " + newGame.getHighestScoreName() + 
            " with " + newGame.getHighestScore() + " points!"); 
         PennDraw.text(0.5, 0.4, "Thanks for playing!"); 
      }
   }
}