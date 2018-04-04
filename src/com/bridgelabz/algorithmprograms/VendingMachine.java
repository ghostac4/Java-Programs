/**
 * Purpose : Calculates the fewest notes to be returned for vending machine
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class VendingMachine
{

   public static void main(String[] args)
   {
      Utility utility = new Utility();

      int[] changeCounts = new int[8];
      int[] changeArray = { 1000, 500, 100, 50, 10, 5, 2, 1 };

      System.out.println("Enter the amount : ");
      int change = utility.readInt();
      int countTotalNotes = 0;

      // calculates the change
      utility.getChange(change, changeCounts, changeArray);

      for (int i = 0; i < changeArray.length; i++) {
         countTotalNotes += changeCounts[i];
         System.out.println(" " + changeArray[i] + " : " + changeCounts[i]);
      }

      // total notes
      System.out.println("Total Notes : " + countTotalNotes);
   }

}
