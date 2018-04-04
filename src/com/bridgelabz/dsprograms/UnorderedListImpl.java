/**
 * Purpose : Implementation of unordered list using linked list
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelabz.dsprograms;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.bridgelabz.utility.UnorderedList;
import com.bridgelabz.utility.Utility;

public class UnorderedListImpl
{

   public static void main(String[] args)
   {
      Utility utility = new Utility();
      UnorderedList<String> list = new UnorderedList<String>();
      String path = "wordList.txt";
      String[] stringList = Utility.readStringsFromFile(path, " ");
      for (int i = 0; i < stringList.length; i++) {
         list.add(stringList[i]);
      }

      list.display();

      System.out.println("\nEnter the string to be searched :");
      String search = utility.readLine();

      if (list.search(search))
         System.out.println("Word found.");
      else
         System.out.println("Word Not Found");
      try {
         OutputStream fos = new FileOutputStream(path);
         OutputStreamWriter osw = new OutputStreamWriter(fos);
         BufferedWriter bw = new BufferedWriter(osw);
         String wordList = "";
         int size = list.size();
         for (int i = 0; i < size; i++) {
            wordList = list.pop() + " " + wordList;
         }
         bw.write(wordList);
         bw.flush();
         bw.close();
      } catch (Exception e) {
         System.out.println(e.toString());
      }
   }

}
