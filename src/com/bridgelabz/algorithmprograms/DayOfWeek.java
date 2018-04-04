/**
 * Purpose : Determines the day of week for given day,month and year
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class DayOfWeek
{

   public static void main(String[] args)
   {

      String[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday" };

      int day = Integer.parseInt(args[0]);
      int month = Integer.parseInt(args[1]);
      int year = Integer.parseInt(args[2]);
      day = Utility.dayOfWeek(day, month, year);

      System.out.println(weekDays[day]);

   }
}
