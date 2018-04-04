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
