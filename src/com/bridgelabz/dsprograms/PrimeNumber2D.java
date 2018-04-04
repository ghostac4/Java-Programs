/**
 * Purpose : Determines prime number which are anagram and palindrome and prints
 * according to the range
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelabz.dsprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bridgelabz.utility.Queue;
import com.bridgelabz.utility.Stack;
import com.bridgelabz.utility.Utility;

public class PrimeNumber2D
{

   @SuppressWarnings("unchecked")
   public static void main(String[] args)
   {
      Utility utility = new Utility();
      List<Integer> primeNumbers = utility.getPrimeNumbers(1000);
      Map<String, String> primeAnagram = utility.getAnagram(primeNumbers);
      List<Integer>[] prime = new List[10];

      for (int i = 0; i < 10; i++) {
         prime[i] = new ArrayList<>();
         for (Integer number : primeNumbers) {
            if (number > i * 100 && number < (i + 1) * 100)
               prime[i].add(number);
         }
      }

      Integer[][] primearray = new Integer[10][];
      for (int i = 0; i < 10; i++) {
         primearray[i] = new Integer[prime[i].size()];
         for (int j = 0; j < prime[i].size(); j++)
            primearray[i][j] = prime[i].get(j);
      }

      System.out.print("*************Prime Number According to Range*************\n");
      for (int i = 0; i < 10; i++) {
         System.out.print(i * 100 + " - " + (i + 1) * 100 + "   :");
         for (int j = 0; j < primearray[i].length; j++)
            System.out.print(" " + primearray[i][j]);

         System.out.print("\n");
      }
      System.out.print("*********************************************************");
      System.out.print("\n");

      List<Integer>[] anagram = new List[10];
      for (int i = 0; i < 10; i++) {
         anagram[i] = new ArrayList<>();
         for (Entry<String, String> row : primeAnagram.entrySet()) {
            if (Integer.parseInt(row.getKey()) > i * 100 && Integer.parseInt(row.getKey()) < (i + 1) * 100) {
               anagram[i].add(Integer.parseInt(row.getKey()));
            }
            if (Integer.parseInt(row.getValue()) > i * 100 && Integer.parseInt(row.getValue()) < (i + 1) * 100) {
               anagram[i].add(Integer.parseInt(row.getValue()));
            }
         }
      }

      Integer[][] primeAnagramArray = new Integer[10][];
      for (int i = 0; i < 10; i++) {
         primeAnagramArray[i] = new Integer[anagram[i].size()];
         for (int j = 0; j < anagram[i].size(); j++)
            primeAnagramArray[i][j] = anagram[i].get(j);

      }

      System.out.print("\n");
      System.out.print("********Prime Number Which are Anagram to Range********\n");
      for (int i = 0; i < 10; i++) {
         System.out.print(i * 100 + " - " + (i + 1) * 100 + "   :");
         for (int j = 0; j < primeAnagramArray[i].length; j++)
            System.out.print(" " + primeAnagramArray[i][j]);

         System.out.print("\n");
      }
      System.out.print("*******************************************************");

      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < 10; i++)
         for (int j = 0; j < primeAnagramArray[i].length; j++)
            stack.push(primeAnagramArray[i][j]);

      System.out.print("\n********Prime Number Which are Anagram in Reverse********\n");
      int stackSize = stack.size();
      for (int i = 0; i < stackSize; i++) {
         System.out.print("\n" + stack.pop());
      }
      System.out.print("\n*******************************************************");

      Queue<Integer> queue = new Queue<>();
      for (int i = 0; i < 10; i++)
         for (int j = 0; j < primeAnagramArray[i].length; j++)
            queue.enqueue(primeAnagramArray[i][j]);

      System.out.print("\n********Prime Number Which are Anagram in Normal Order********\n");
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
         System.out.print("\n" + queue.dequeue());
      }
      System.out.print("\n*******************************************************");
   }

}
