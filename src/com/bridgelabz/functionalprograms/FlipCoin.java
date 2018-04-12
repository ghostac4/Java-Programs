/**
 * Purpose : Determines the Percentage of Heads and Tails using Random Number
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 12-03-2018
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class FlipCoin
{

   public static void main(String args[])
   {
      Utility utility = new Utility();
      int flipNumber;
      int countTails = 0;

      do {
         System.out.println("Enter the number of times to Flip Coin (Positive Integer Only):");
         flipNumber = utility.readInt();
      } while (flipNumber < 0);

      float randomNumber;

      for (int i = 0; i < flipNumber; i++) {

         randomNumber = (float) Math.random();

         if (randomNumber < 0.5)
            countTails++;
      }
      System.out.println(countTails);

      if (countTails < 1)
         System.out.println("Tails : 0% | Heads : 100%");
      else {
         float tailsPercentage = ((countTails * 100.0f) / flipNumber);
         System.out.print("Tails : " + tailsPercentage + "% | Heads : ");
         System.out.println(100 - tailsPercentage + "%");
      }
   }
}
