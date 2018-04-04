
/**
 * Purpose : Gives all the permutation of a string
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Permutation
{
   public static void main(String args[])
   {
      Utility utility = new Utility();
      System.out.println("Enter the String : ");
      String input = utility.readLine();

      Utility.permutation(input, 0, input.length() - 1);
   }
}
