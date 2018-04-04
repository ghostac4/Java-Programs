/**
 * Purpose : Program for JSON inventory data management
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelabz.ooprograms;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.bridgelabz.utility.Utility;

public class JSONInventory
{

   @SuppressWarnings("unchecked")
   public static void main(String[] args)
   {
      Utility utility = new Utility();
      String path = "jsonOutput.json";
      int choice;
      JSONArray jsonArray = new JSONArray();
      List<Inventory> inventoryList = null;
      String jsonStringInput = "";
      do {
         System.out.print("\n**********************************************************");
         System.out.print("\n                 1.Enter Inventory Details.");
         System.out.print("\n                 2.Write JSON Inventory File.");
         System.out.print("\n                 3.Read JSON Inventory File.");
         System.out.print("\n                 4.Calculate Inventory Value.");
         System.out.print("\n                 5.Print JSON String.");
         System.out.print("\n                 6.Quit.");
         System.out.print("\n**********************************************************");
         System.out.print("\nEnter the Choice :");
         choice = utility.readInt();
         switch (choice) {
         case 1:
            System.out.print("\nEnter Property name :");
            utility.readLine();
            String property = utility.readLine();
            System.out.print("\nEnter Weight :");
            int weight = utility.readInt();
            System.out.print("\nEnter Price per kg :");
            float price = utility.readFloat();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", property);
            jsonObject.put("weight", weight);
            jsonObject.put("price", price);
            jsonArray.add(jsonObject);
            break;
         case 2:
            jsonStringInput = JSONValue.toJSONString(jsonArray);
            Utility.writeToFile(jsonStringInput, path);
            break;
         case 3:
            jsonStringInput = Utility.readFromFile(path);
            JSONArray jsonArray2 = (JSONArray) JSONValue.parse(jsonStringInput);
            JSONObject jsonObject2 = null;
            inventoryList = new ArrayList<>();
            System.out.print("\n***************************Inventory Details*******************\n");

            for (int i = 0; i < jsonArray2.size(); i++) {
               Inventory inventory = new Inventory();
               System.out.print("\n**********************************************************");
               jsonObject2 = (JSONObject) jsonArray2.get(i);
               System.out.print("\nName :" + jsonObject2.get("name"));
               inventory.setName((String) jsonObject2.get("name"));
               System.out.print("\nWeight :" + jsonObject2.get("weight"));
               inventory.setWeight(((Long) jsonObject2.get("weight")).intValue());
               System.out.print("\nPrice :" + jsonObject2.get("price"));
               inventory.setPrice(((Double) jsonObject2.get("price")).floatValue());
               inventoryList.add(inventory);
               System.out.print("\n**********************************************************");
            }
            break;
         case 4:
            if (inventoryList == null) {
               System.out.print("\nRead the json file first!!!");
            } else {
               System.out.print("\n***********Total Value of each inventory****************");
               System.out.print("\n Name   | Total Value in Inventory");

               for (Inventory inventory : inventoryList) {
                  String name = inventory.getName();
                  int weight2 = inventory.getWeight();
                  float price2 = inventory.getPrice();
                  System.out.print("\n " + name + "   : " + (weight2 * price2));
               }
               System.out.print("\n*********************************************************");
            }
            break;
         case 5:
            System.out.print("\n*********************JSON String*******************");
            System.out.print("\n" + jsonStringInput);
            System.out.print("\n****************************************************");
            break;
         case 6:
         default:
            break;
         }
      } while (choice != 6);
   }

}
