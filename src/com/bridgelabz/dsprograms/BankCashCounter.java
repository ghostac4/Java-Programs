/**
 * Purpose : Simulation of bank cash counter
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 */
package com.bridgelabz.dsprograms;

import com.bridgelabz.utility.Queue;
import com.bridgelabz.utility.Utility;

public class BankCashCounter
{
   private static int BALANCE = 1000000;

   public static void main(String[] args)
   {
      Utility utility = new Utility();
      Queue<Integer> queue = new Queue<>();
      int choice;
      do {
         System.out.print("\n****************Bank Cash Counter********************");
         System.out.print("\n                   1. Add to queue");
         System.out.print("\n                   2. Remove from queue");
         System.out.print("\n                   3. Queue Size");
         System.out.print("\n                   4. Display queue");
         System.out.print("\n                   5. Display Balance");
         System.out.print("\n                   6. Quit");
         System.out.print("\n*****************************************************");
         System.out.print("\nEnter the choice : ");
         choice = utility.readInt();

         switch (choice) {
         case 1:
            int choice2;
            System.out.print("\n*****************************************************");
            System.out.print("\n			  1. To Deposit");
            System.out.print("\n			  2. To WithDrwaw");
            System.out.print("\nEnter Choice  : ");
            System.out.print("\n*****************************************************");
            choice2 = utility.readInt();
            switch (choice2) {
            case 1:
               System.out.print("\n*****************************************************");
               System.out.print("\nEnter the amount to Deposit : ");
               System.out.print("\n*****************************************************");
               queue.enqueue(utility.readInt());
               break;
            case 2:
               System.out.print("\n*****************************************************");
               System.out.print("\nEnter the amount to Withdraw : ");
               System.out.print("\n*****************************************************");
               queue.enqueue(0 - utility.readInt());
               break;
            default : System.out.print("\nInvalid Choice!!!");
            }
            break;
         case 2:
            Integer amount = queue.dequeue();
            if (amount == null) {
               System.out.print("\nQueue Already Emplty");
            } else {
               if ((BALANCE + amount) < 0) {
                  System.out.print("\nInsufficient Balance for withdraw");
                  System.out.print("\nNext...");
               } else {
                  if (amount < 0) {
                     BALANCE = BALANCE + amount;
                     System.out.print("\nWithdraw Successfull");
                     System.out.print("\nNext...");
                  } else {
                     BALANCE = BALANCE + amount;
                     System.out.print("\nDeposit Successfull");
                     System.out.print("\nNext...");
                  }
               }
            }
            break;
         case 3:
            System.out.print("\nSize of queue : " + queue.size());
            break;
         case 4:
            System.out.print("\nQueue : ");
            queue.display();
         case 5:
            System.out.print("\nBank Balance : " + BALANCE);
            break;
         case 6:
            break;
         default : System.out.print("\nInvalid Choice!!!");
         }
      } while (choice != 6);
   }
}
