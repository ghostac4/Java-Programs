package com.bridgelabz.ooprograms;

public class CompanyShares
{

   private String symbol;
   private int shares;
   private float price;

   public void setShares(int shares)
   {
      this.shares = shares;
   }

   public float getPrice()
   {
      return price;
   }

   public void setPrice(float price)
   {
      this.price = price;
   }

   public String getSymbol()
   {
      return symbol;
   }

   public void setSymbol(String symbol)
   {
      this.symbol = symbol;
   }

   public boolean isAvailable(int shares)
   {
      return (this.shares > shares);
   }

   public int getShares()
   {
      return shares;
   }
}
