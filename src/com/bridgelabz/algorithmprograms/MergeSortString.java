/**
 * Purpose : Implementation of merge sort
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class MergeSortString
{

   public static void main(String[] args)
   {
      String path = "wordList.txt";
      String separator = " ";
      String[] wordList = Utility.readStringsFromFile(path, separator);

      System.out.println("List of unsorted words :");

      for (String word : wordList)
         System.out.print(word + " ");

      Utility.mergeSort(wordList);

      System.out.println("\nList of sorted words :");

      for (String word : wordList)
         System.out.print(word + " ");
   }

}
