/**
 * Purpose : Maintains the data of stock account and company shares
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelabz.ooprograms;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.bridgelabz.utility.Queue;
import com.bridgelabz.utility.Stack;
import com.bridgelabz.utility.UnorderedList;
import com.bridgelabz.utility.Utility;

public class StockAccount
{

   private float amount;
   private String path = "";

   private UnorderedList<CompanyShares> companySharesInAccount;
   private Queue<String> dateTime;
   private Stack<Transaction> transactionStack;
   private List<CompanyShares> companySharesList;

   /**
    * constructor to initialize the path and other data members
    * 
    * @param filename is string for path
    * @throws IOException for file object
    */
   public StockAccount(String filename) throws IOException
   {
      path = path + filename + ".json";
      companySharesInAccount = new UnorderedList<>();
      dateTime = new Queue<>();
      transactionStack = new Stack<>();
      File file = new File(path);
      if (file.createNewFile()) {
         save(path);
      } else {
         getAccountData(path);
         getCompanyShares();
      }
   }

   /**
    * function to buy shares from the company list
    * 
    * @param amount required to buy shares
    * @param symbol is string representing company
    */
   public void buy(int amount, String symbol)
   {
      for (CompanyShares cShares : companySharesList) {
         if (cShares.getSymbol().equals(symbol)) {
            int shares = (int) (amount / cShares.getPrice());
            if (cShares.isAvailable(shares)) {
               cShares.setShares(cShares.getShares() - shares);
               ;
               this.amount = this.amount - (cShares.getPrice() * shares);

               int size = companySharesInAccount.size();
               boolean flag = false;
               for (int i = 0; i < size; i++) {
                  CompanyShares companyShares = companySharesInAccount.pop(0);
                  if (companyShares.getSymbol().equals(symbol)) {
                     companyShares.setShares(companyShares.getShares() + shares);
                     flag = true;
                  }
                  companySharesInAccount.add(companyShares);
               }
               if (!flag) {
                  CompanyShares myShares = new CompanyShares();
                  myShares.setPrice(cShares.getPrice());
                  myShares.setShares(shares);
                  myShares.setSymbol(symbol);
                  companySharesInAccount.add(myShares);
               }
               SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
               Date date = new Date();
               dateTime.enqueue(formatter.format(date));
               Transaction transaction = new Transaction();
               transaction.setMode("Buy");
               transaction.setSymbol(symbol);
               transactionStack.push(transaction);
               break;
            } else {
               System.out.print("\nShares Not Available");
            }
         }
      }
   }

   /**
    * function to sell the shares
    * 
    * @param amount of shares to sell
    * @param symbol representing the company
    */
   public void sell(int amount, String symbol)
   {
      int size = companySharesInAccount.size();
      outer: for (int i = 0; i < size; i++) {
         CompanyShares cShares = companySharesInAccount.pop(0);
         if (cShares.getSymbol().equals(symbol)) {
            for (CompanyShares cShares2 : companySharesList) {
               int shares = (int) (amount / cShares2.getPrice());
               cShares.setShares(cShares.getShares() - shares);
               cShares2.setShares(cShares2.getShares() + shares);
               if (cShares.getShares() != 0)
                  companySharesInAccount.add(cShares);
               SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
               Date date = new Date();
               dateTime.enqueue(formatter.format(date));
               Transaction transaction = new Transaction();
               transaction.setMode("Sell");
               transaction.setSymbol(symbol);
               transactionStack.push(transaction);
               break outer;
            }
         }
         companySharesInAccount.add(cShares);
      }
   }

   /**
    * function to save all the account data into file
    * 
    * @param filename is a string name of file
    */
   @SuppressWarnings("unchecked")
   public void save(String filename)
   {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("amount", amount);
      if (companySharesInAccount.isEmpty()) {
         jsonObject.put("companyShares", null);
         jsonObject.put("dateTime", null);
         jsonObject.put("transactions", null);
      } else {
         JSONArray cjJsonArray = new JSONArray();
         int size = companySharesInAccount.size();
         for (int i = 0; i < size; i++) {
            JSONObject csjsonObject = new JSONObject();
            CompanyShares companyShares = companySharesInAccount.pop();
            csjsonObject.put("symbol", companyShares.getSymbol());
            csjsonObject.put("shares", companyShares.getShares());
            csjsonObject.put("price", companyShares.getPrice());
            cjJsonArray.add(csjsonObject);
         }
         jsonObject.put("companyShares", cjJsonArray);
         JSONArray dtJsonArray = new JSONArray();
         size = dateTime.size();
         for (int i = 0; i < size; i++) {
            JSONObject dtJsonObject = new JSONObject();
            dtJsonObject.put("dt", dateTime.dequeue());
            dtJsonArray.add(dtJsonObject);
         }
         jsonObject.put("dateTime", dtJsonArray);
         JSONArray tJsonArray = new JSONArray();
         size = transactionStack.size();
         for (int i = 0; i < size; i++) {
            JSONObject tJsonObject = new JSONObject();
            Transaction transaction = transactionStack.pop();
            tJsonObject.put("mode", transaction.getMode());
            tJsonObject.put("symbol", transaction.getSymbol());
            tJsonArray.add(tJsonObject);
         }
         jsonObject.put("transactions", tJsonArray);
      }

      String jsonStringInput = JSONValue.toJSONString(jsonObject);
      Utility.writeToFile(jsonStringInput, path);
      saveCompanyShares();
   }

   /**
    * function to print all the data
    */
   public void printReport()
   {
      System.out.print("\n******************My Account Report********************");
      System.out.print("\n-------------------------------------------------------");
      System.out.print("\n Balance Amount : Rs. " + amount);
      System.out.print("\n-------------------------------------------------------");
      System.out.print("\n-----------------------My Shares-----------------------");
      int size = companySharesInAccount.size();
      System.out.print("\n       Company Symbol |   Shares   |    Price  ");
      for (int i = 0; i < size; i++) {
         CompanyShares companyShares = companySharesInAccount.pop(0);
         System.out.print("\n                   " + companyShares.getSymbol() + " |   " + companyShares.getShares()
               + "   |    " + companyShares.getPrice() + "  ");
         companySharesInAccount.add(companyShares);
      }
      System.out.print("\n-------------------------------------------------------");
      System.out.print("\n-----------------------Transactions--------------------");
      Stack<Transaction> tempStack = new Stack<>();
      while (!transactionStack.isEmpty()) {
         Transaction transaction = transactionStack.pop();
         System.out.print("\n             " + transaction.getMode() + " -->   " + transaction.getSymbol());
         tempStack.push(transaction);
      }
      transactionStack = tempStack;
      System.out.print("\n-------------------------------------------------------");
      System.out.print("\n-------------------Date Time(Transactions)-------------");
      size = dateTime.size();
      for (int i = 0; i < size; i++) {
         String dateDisplay = dateTime.dequeue();
         System.out.print("\n             " + dateDisplay);
         dateTime.enqueue(dateDisplay);
      }
      System.out.print("\n-------------------------------------------------------");
      System.out.print("\n*******************************************************");
   }

   /**
    * function to get the amount of balance
    * 
    * @return number balance amount
    */
   public float getAmount()
   {
      return amount;
   }

   /**
    * function to set the amount balance
    * 
    * @param amount number balance amount
    */
   public void setAmount(float amount)
   {
      this.amount = amount;
   }

   /**
    * function to get the account data from FILE
    * 
    * @param path is string of file path
    */
   private void getAccountData(String path)
   {
      String jsonStringInput = Utility.readFromFile(path);
      JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonStringInput);
      amount = ((Double) jsonObject.get("amount")).floatValue();
      JSONArray cJsonArray = (JSONArray) jsonObject.get("companyShares");
      JSONArray dtJsonArray = (JSONArray) jsonObject.get("dateTime");
      JSONArray tsJsonArray = (JSONArray) jsonObject.get("transactions");
      if (cJsonArray != null && dtJsonArray != null && tsJsonArray != null) {
         for (int i = 0; i < cJsonArray.size(); i++) {
            JSONObject tempObject = (JSONObject) cJsonArray.get(i);
            CompanyShares cShares = new CompanyShares();
            cShares.setSymbol((String) tempObject.get("symbol"));
            cShares.setShares(((Long) tempObject.get("shares")).intValue());
            cShares.setPrice(((Double) tempObject.get("price")).floatValue());
            companySharesInAccount.add(cShares);
         }
         for (int i = 0; i < dtJsonArray.size(); i++) {
            JSONObject tempObject = (JSONObject) dtJsonArray.get(i);
            String dateTimeString = (String) tempObject.get("dt");
            dateTime.enqueue(dateTimeString);
         }
         for (int i = 0; i < tsJsonArray.size(); i++) {
            JSONObject tempObject = (JSONObject) tsJsonArray.get(i);
            Transaction transaction = new Transaction();
            transaction.setMode((String) tempObject.get("mode"));
            transaction.setSymbol((String) tempObject.get("symbol"));
            transactionStack.push(transaction);
         }
      }
   }

   /**
    * function to get the company shares from the file
    */
   public void getCompanyShares()
   {
      String jsonStringInput = Utility.readFromFile("stockList.json");
      JSONArray jsonArray2 = (JSONArray) JSONValue.parse(jsonStringInput);
      JSONObject jsonObject2 = null;
      companySharesList = new ArrayList<>();
      for (int i = 0; i < jsonArray2.size(); i++) {
         CompanyShares cShares = new CompanyShares();
         jsonObject2 = (JSONObject) jsonArray2.get(i);
         cShares.setSymbol((String) jsonObject2.get("symbol"));
         cShares.setShares(((Long) jsonObject2.get("shares")).intValue());
         cShares.setPrice(((Double) jsonObject2.get("price")).floatValue());
         companySharesList.add(cShares);
      }
   }

   /**
    * function to save the company shares in the file
    */
   @SuppressWarnings("unchecked")
   public void saveCompanyShares()
   {
      JSONArray jsonArray = new JSONArray();
      if (companySharesList != null) {
         for (CompanyShares cShares : companySharesList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("symbol", cShares.getSymbol());
            jsonObject.put("shares", cShares.getShares());
            jsonObject.put("price", cShares.getPrice());
            jsonArray.add(jsonObject);
         }
         Utility.writeToFile(JSONValue.toJSONString(jsonArray), "companyShares.json");
      }
   }
}
