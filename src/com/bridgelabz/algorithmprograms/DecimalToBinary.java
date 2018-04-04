/**
 * Purpose : Program to convert decimal number into binary
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class DecimalToBinary
{

   public static void main(String[] args)
   {
      Utility utility = new Utility();
      System.out.println("Enter the decimal number :");
      int decimal = utility.readInt();
      String binary = Utility.toBinary(decimal);
      System.out.println("Binary Conversion : " + binary);
   }

}
