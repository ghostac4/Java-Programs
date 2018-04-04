package com.bridgelabz.facadepattern;

public class ShopKeeper
{

   private MobileShop iPhone;
   private MobileShop samsung;
   private MobileShop motorola;

   public ShopKeeper()
   {
      iPhone = new IPhone();
      samsung = new Samsung();
      motorola = new Motorola();
   }

   public void iPhoneSale()
   {
      iPhone.mobileNo();
      iPhone.price();
   }

   public void samsungSale()
   {
      samsung.mobileNo();
      samsung.price();
   }

   public void motorolaSale()
   {
      motorola.mobileNo();
      motorola.price();
   }
}
