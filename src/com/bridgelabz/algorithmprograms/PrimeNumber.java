/**
 * Purpose : Generates all the prime numbers between 0 and 1000
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import java.util.List;

import com.bridgelabz.utility.Utility;

public class PrimeNumber
{

   public static void main(String[] args)
   {
      Utility utility = new Utility();

      List<Integer> list = utility.getPrimeNumbers(1000);

      for (Integer i : list)
         System.out.println(i);
   }

}
