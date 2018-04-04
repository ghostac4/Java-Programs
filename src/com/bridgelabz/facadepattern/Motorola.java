/**
 * Purpose : Class Motorola Facade Design Pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
package com.bridgelabz.facadepattern;

public class Motorola implements MobileShop
{

   @Override
   public void mobileNo()
   {
      System.out.print("\nMoto G5 plus");
   }

   @Override
   public void price()
   {
      System.out.print("\nRs.25,000");
   }

}
