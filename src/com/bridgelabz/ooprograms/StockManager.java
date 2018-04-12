/**
 * Purpose : Implementation of StockAccount and company shares
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelabz.ooprograms;

import java.io.IOException;
import com.bridgelabz.utility.Utility;

public class StockManager
{

   public static void main(String[] args) throws IOException
   {
      Utility utility = new Utility();
      int choice;
      int amount;
      String symbol;

      do {
         System.out.print("\n                  : 1.Create New Account");
         System.out.print("\n                  : 2.Open Existing Account");
         System.out.print("\n                  : 3.Quit");
         System.out.print("\nEnter your Choice : ");
         choice = utility.readInt();
         switch (choice) {
         case 1:
            utility.readLine();
            System.out.print("\nEnter your Name : ");
            String name = utility.readLine();
            System.out.print("\nEnter the amount : ");
            amount = utility.readInt();
            StockAccount stockAccount = new StockAccount(name);
            stockAccount.setAmount(amount);
            stockAccount.save(name);
            break;
         case 2:
            int choice2;
            utility.readLine();
            System.out.print("\nEnter your Name : ");
            String name2 = utility.readLine();
            StockAccount stockAccount2 = new StockAccount(name2);
            do {
               System.out.print("\n                  : 1.Buy Shares of Stock.");
               System.out.print("\n                  : 2.Sell Shares of Stock.");
               System.out.print("\n                  : 3.Save Account in File.");
               System.out.print("\n                  : 4.Print Report.");
               System.out.print("\n                  : 5.Logout.");
               System.out.print("\nEnter your Choice : ");
               choice2 = utility.readInt();
               switch (choice2) {
               case 1:
                  utility.readLine();
                  System.out.print("\nEnter your Company Symbol : ");
                  symbol = utility.readLine();
                  System.out.print("\nEnter the amount : ");
                  amount = utility.readInt();
                  stockAccount2.buy(amount, symbol);
                  break;
               case 2:
                  utility.readLine();
                  System.out.print("\nEnter your Company Symbol : ");
                  symbol = utility.readLine();
                  System.out.print("\nEnter the amount : ");
                  amount = utility.readInt();
                  stockAccount2.sell(amount, symbol);
                  break;
               case 3:
                  stockAccount2.save(name2);
                  break;
               case 4:
                  stockAccount2.printReport();
                  break;
               default:
                  break;
               }
            } while (choice2 != 5);
            break;
         case 3: break;
         default : System.out.print("\nInvalid choice!!!");
         }
      } while (choice != 3);
   }

}
