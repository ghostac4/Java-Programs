/**
 * Purpose : Class IPhone for Facade Design Pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
package com.bridgelabz.facadepattern;

public class IPhone implements MobileShop
{

   @Override
   public void mobileNo()
   {
      System.out.print("\nIPhone X");
   }

   @Override
   public void price()
   {
      System.out.print("\nRs.90,000");
   }

}
