/**
 * Purpose : Class ShopKeeper for Facade Design Pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
package com.bridgelabz.facadepattern;

public class ShopKeeper
{

   private MobileShop iPhone;
   private MobileShop samsung;
   private MobileShop motorola;

   /**
    *constructor for ShoppKeeper Class 
    */
   public ShopKeeper()
   {
      iPhone = new IPhone();
      samsung = new Samsung();
      motorola = new Motorola();
   }

   /**
    *function to call iPhone class methods 
    */
   public void iPhoneSale()
   {
      iPhone.mobileNo();
      iPhone.price();
   }

   /**
    *function to call samsung class methods 
    */
   public void samsungSale()
   {
      samsung.mobileNo();
      samsung.price();
   }

   /**
    *function to call motorola class methods 
    */
   public void motorolaSale()
   {
      motorola.mobileNo();
      motorola.price();
   }
}
