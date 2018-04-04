/**
 * Purpose : Simulation of gambler to get percentage of win and loss
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 12-03-2018
 */

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Gambler
{

   public static void main(String args[])
   {
      Utility utility = new Utility();
      System.out.println("Enter stake : ");
      int stake = utility.readInt();
      System.out.println("Enter goal : ");
      int goal = utility.readInt();
      System.out.println("Enter Number of times to play : ");
      int rounds = utility.readInt();
      int winCount = 0;
      float random;

      for (int i = 0; i < rounds; i++) {

         // to hold the stake value temporary
         int tempStake = stake;

         // until the player wins or lose
         while (!(tempStake == goal) && tempStake > 0) {
            random = (float) Math.random();

            if (random < 0.5)
               tempStake++;
            else
               tempStake--;
         }

         // checks if the player wins
         if (tempStake == goal)
            winCount++;
      }
      System.out.println("Number of Wins :" + winCount);

      if (winCount < 1)
         System.out.println("Wins : 0% | Loss : 100%");
      else {
         float winsPercentage = ((winCount * 100.0f) / rounds);
         System.out.print("Wins : " + winsPercentage + "% | Loss : ");
         System.out.println(100 - winsPercentage + "%");
      }
   }
}
