
/**
 * Purpose : Calculates Euclidean distance from point (x,y) to origin
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 12-03-2018
 */

package com.bridgelabz.functionalprograms;

public class Distance
{

   public static void main(String args[])
   {
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);
      double x2 = Math.pow(x, 2);
      double y2 = Math.pow(y, 2);
      double x2y2 = x2 + y2;
      System.out.println("The Distance between (" + x + "," + y + ") is " + Math.sqrt(x2y2));
   }
}
