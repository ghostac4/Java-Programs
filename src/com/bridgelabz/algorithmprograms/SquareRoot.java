/**
 * Purpose : Finding square root of a number using newtons method
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class SquareRoot
{

   public static void main(String[] args)
   {
      Utility utility = new Utility();
      System.out.println("Enter the number for square root :");
      int number = utility.readInt();
      System.out.println("The square root of " + number + " is " + "" + Utility.sqrt(number));
   }
}
