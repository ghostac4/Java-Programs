/**
 * Purpose : Determines number of binary search tree can be formed from given
 * number
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.dsprograms;

import com.bridgelabz.utility.Utility;

public class NumberOfBST
{

   public static void main(String[] args)
   {
      Utility utility = new Utility();
      System.out.print("\nEnter the number of test cases :");
      int testCases = utility.readInt();
      System.out.print("\nEnter the numbers : ");
      int[] numbers = new int[testCases];

      for (int i = 0; i < testCases; i++)
         numbers[i] = utility.readInt();

      for (int i = 0; i < testCases; i++)
         System.out.print("\n" + Utility.getNumberOfBST(numbers[i]));
   }
}
