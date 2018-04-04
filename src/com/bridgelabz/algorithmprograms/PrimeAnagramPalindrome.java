/**
 * Purpose : Generates the list of prime numbers which are anagram and
 * palindrome
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import java.util.List;
import java.util.Map;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramPalindrome
{

   public static void main(String[] args)
   {

      Utility utility = new Utility();
      List<Integer> list = utility.getPrimeNumbers(1000);
      List<Integer> palindromeList = utility.getPalindrome(list);

      // question 2-Prime number which are palindrome
      System.out.print("List of Prime Numbers which are palindrome : ( ");
      for (Integer palindromeInt : palindromeList) {
         System.out.print(palindromeInt + " ");
      }
      System.out.println(")");

      // Question 3-Prime number which are anagram
      System.out.println("List of Prime Numbers which are anagram : ");

      Map<String, String> primeAnagrams = utility.getAnagram(list);
      for (Map.Entry<String, String> m : primeAnagrams.entrySet())
         System.out.println("           {" + m.getKey() + " --> " + m.getValue() + "}");
   }
}
