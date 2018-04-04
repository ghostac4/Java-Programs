
/**
 * Purpose : Determines if a string is an anagram or not
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class AnagramDetection
{

   public static void main(String[] args)
   {
      Utility utility = new Utility();

      System.out.println("Enter the string 1 :");
      String string1 = utility.readLine();
      System.out.println("Enter the string 2 :");
      String string2 = utility.readLine();

      if (utility.detectAnagram(string1.toLowerCase(), string2.toLowerCase()))
         System.out.println("The two strings are Anagram.");
      else
         System.out.println("The two strings are not Anagram.");
   }

}
