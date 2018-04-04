/**
 * Purpose : Generates N distinct coupon number.
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */

package com.bridgelabz.functionalprograms;

import java.util.ArrayList;
import java.util.List;
import com.bridgelabz.utility.Utility;

public class CouponNumber
{

   public static void main(String args[])
   {
      Utility utility = new Utility();

      List<Integer> coupons = new ArrayList<Integer>();

      System.out.println("Enter the number of Coupons :");
      int totalCoupons = utility.readInt();
      int totalRandom = 0;

      for (int i = 0; i < totalCoupons; i++) {

         int couponNumber = Utility.randomGenerator(totalCoupons);
         totalRandom++;

         // if couponNumber is distinct then add to list
         if (Utility.isDistinct(coupons, couponNumber))
            coupons.add(couponNumber);
         else
            i--;
      }

      for (Integer i : coupons) {
         // Prints each coupon from list
         System.out.println(i);
      }

      System.out.println("Total Random Number :" + totalRandom);
   }

}
