
/**
 * Purpose : Determines the given year is leap year or not
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 12-03-2018
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class LeapYear
{

   public static void main(String args[])
   {
      Utility utility = new Utility();
      int year;
      do {
         System.out.println("Enter valid Year :");
         year = utility.readInt();

         // runs until user enters valid input
      } while (!(year > 999 && year < 10000));

      if (year % 4 == 0)
         if (year % 100 == 0)
            if (year % 400 == 0)
               System.out.println(year + " is a Leap Year");
            else
               System.out.println(year + " is not a Leap Year");
         else
            System.out.println(year + " is a Leap year");
      else
         System.out.println(year + " is Not a Leap year.");
   }
}
