package com.bridgelabz.ooprograms;

public class Stock
{

   private String name;
   private int shares;
   private float price;

   /**
    * function to get the name
    * 
    * @return name is a string
    */
   public String getName()
   {
      return name;
   }

   /**
    * function to set name
    * 
    * @param name is a string
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * function to get shares
    * 
    * @return number of shares
    */
   public int getShares()
   {
      return shares;
   }

   /**
    * function to set shares
    * 
    * @param shares is a number
    */
   public void setShares(int shares)
   {
      this.shares = shares;
   }

   /**
    * function to get price
    * 
    * @return price is a number
    */
   public float getPrice()
   {
      return price;
   }

   /**
    * function to set the price
    * 
    * @param price is a number
    */
   public void setPrice(float price)
   {
      this.price = price;
   }

   /**
    * function to calculate the value of shares
    * 
    * @return total value of shares
    */
   public float getValue()
   {
      return shares * price;
   }
}
