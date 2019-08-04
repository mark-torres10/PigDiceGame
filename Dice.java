/*
   Name: Mark Torres

   Execution: java Dice

   Public class Dice
   -------------------------------------------------------------
   Rolls a dice. The API is:

   static int roll.          // rolls the dice
 */

public class Dice {
   // Initialize variables
   int roll;

   // Roll the dice
   public static int roll() {
      int roll = (int) (Math.random() * 6) + 1;
      return roll; 
   }
}


