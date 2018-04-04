/**
 * Purpose : Class Samsunf for Facade Design Pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
package com.bridgelabz.facadepattern;

public class Samsung implements MobileShop
{

   @Override
   public void mobileNo()
   {
      System.out.print("\nSamsung S9 Edge");
   }

   @Override
   public void price()
   {
      System.out.print("\nRs.70,000");
   }

}
