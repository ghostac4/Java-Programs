/**
 * Purpose : Checks if the string is a palindrome or not using stack
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.dsprograms;

import com.bridgelabz.utility.DEQueue;
import com.bridgelabz.utility.Utility;

public class PalindromeChecker
{

   public static void main(String[] args)
   {
      Utility utility = new Utility();
      System.out.print("\nEnter the string to check for palindrome :");
      String string1 = utility.readLine();
      DEQueue<String> deQueue = new DEQueue<>();

      for (int i = string1.length() - 1; i >= 0; i--)
         deQueue.addRear(string1.charAt(i) + "");

      deQueue.displayFromFront();
      String string2 = "";

      for (int i = 0; i < string1.length(); i++)
         string2 = string2 + deQueue.removeFront();

      if (string1.equals(string2))
         System.out.print("\nTrue");
      else
         System.out.print("\nFalse");
   }

}
