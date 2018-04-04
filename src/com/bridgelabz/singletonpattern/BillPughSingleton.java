package com.bridgelabz.singletonpattern;

public class BillPughSingleton
{

   private BillPughSingleton()
   {
   }

   private static class BillPughHelper
   {
      private static final BillPughSingleton BILL_PUGH_SINGLETON = new BillPughSingleton();
   }

   public static BillPughSingleton getInstance()
   {
      return BillPughHelper.BILL_PUGH_SINGLETON;
   }
}
