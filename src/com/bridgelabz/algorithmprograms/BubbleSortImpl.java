
/**
 * Purpose : Implementation of bubble sort
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class BubbleSortImpl
{

   public static void main(String[] args)
   {
      String path = "intList.txt";

      String separator = " ";

      String[] intString = Utility.readStringsFromFile(path, separator);
      Integer[] intList = new Integer[intString.length];

      for (int i = 0; i < intList.length; i++)
         intList[i] = Integer.parseInt(intString[i]);

      Utility.bubbleSort(intList);

      for (Integer i : intList)
         System.out.print(i + " ");
   }

}
