
/**
 * Purpose : Replace the String template with User input
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-03-2018
 */

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class ReplaceStringTemplate
{

   public static void main(String[] args)
   {
      String template = "Hello <<UserName>>, How are you?", username;
      Utility utility = new Utility();

      do {
         System.out.println("Enter your name (min 3 char) :");
         username = utility.readLine();
      } while (!(username.length() > 3));

      String output = template.replace("<<UserName>>", username);
      System.out.println(output);
   }
}
