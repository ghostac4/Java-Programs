/**
 * Purpose : Program for inventory management 
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelab.ooprograms;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.bridgelab.utility.Utility;

public class InventoryManager {

	public static void main(String[] args) {
		Utility utility = new Utility();
		int choice;
		do{
			System.out.print("\n********************Inventory Details***************************");
			System.out.print("\n                 : 1. Calculate Inventory Price");
			System.out.print("\n                 : 2. Print JSON String");
			System.out.print("\n                 : 3. Quit");
			System.out.print("\nEnter the choice : ");
			choice = utility.readInt();
			List<Inventory> inventoryList= inventoryFactory();
			switch(choice){
			case 1 : System.out.print("\n****************************************************************");
					System.out.print("\n--------Name---------------Total Value--------------------------");
					for(Inventory inventory : inventoryList){
						System.out.print("\n        "+inventory.getName()+"              :Rs."+inventory.getValue());
						System.out.print("\n----------------------------------------------------------------");
					}
					System.out.print("\n****************************************************************");
					break;
			case 2 : 
				int i=1;
				for(Inventory inventory : inventoryList){
				System.out.print("\n                                       :"+i+". "+inventory.getName());
				i++;
				}
				System.out.print("\nEnter the choice to get JSON String of :");
				i = utility.readInt();
				System.out.print("\nJSON String : "+inventoryList.get(i-1).getJSONString());
			}
		}while(choice != 3);
	}

	public static List<Inventory> inventoryFactory(){
		String jsonStringInput = Utility.readFromFile("jsonOutput.json");
		JSONArray jsonArray2 = (JSONArray) JSONValue.parse(jsonStringInput);
		JSONObject jsonObject2=null;
		List<Inventory> inventoryList = new ArrayList<>();
		for(int i=0;i<jsonArray2.size();i++){
			Inventory inventory = new Inventory();						
			jsonObject2 = (JSONObject) jsonArray2.get(i);
			inventory.setName((String)jsonObject2.get("name"));
			inventory.setWeight(((Long) jsonObject2.get("weight")).intValue());
			inventory.setPrice(((Double)jsonObject2.get("price")).floatValue());
			inventoryList.add(inventory);
		}
		return inventoryList;
	}
}
