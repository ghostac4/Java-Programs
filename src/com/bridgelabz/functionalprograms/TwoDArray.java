
/**
 * Purpose : Reading two dimensional array using scanner and printing with
 * outputstream
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */
package com.bridgelabz.functionalprograms;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class TwoDArray
{

   public static void main(String args[])
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter m*n value : ");
      int m = sc.nextInt();
      int n = sc.nextInt();
      System.out.println("Select DataType Option : 1. Integer 2. Double 3.Boolean");
      int choice = sc.nextInt();

      switch (choice) {
      case 1:
         Integer[][] arr1 = new Integer[m][n];
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               arr1[i][j] = sc.nextInt();
            }
         }
         Utility.display(arr1);
         break;
      case 2:
         Double[][] arr2 = new Double[m][n];
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               arr2[i][j] = sc.nextDouble();
            }
         }
         Utility.display(arr2);
         break;
      case 3:
         Boolean[][] arr3 = new Boolean[m][n];
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               arr3[i][j] = sc.nextBoolean();
            }
         }
         Utility.display(arr3);
         break;
      default:
         System.out.println("Invalid Choice");
      }
      sc.close();
   }
}
