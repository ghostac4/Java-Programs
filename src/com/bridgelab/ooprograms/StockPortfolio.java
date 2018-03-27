/**
 * Purpose : Program for Stock report and portfolio
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

public class StockPortfolio {

	public static void main(String[] args) {
		List<Stock> stockList;
		String path = "/home/bridgeit/Desktop/List/stockList.json";
		String jsonStringInput = Utility.readFromFile(path);
		JSONArray jsonArray2 = (JSONArray) JSONValue.parse(jsonStringInput);
		JSONObject jsonObject2 = null;
		stockList = new ArrayList<>();
		System.out.print("\n***************************Stock Portfolio*******************\n");
		for (int i = 0; i < jsonArray2.size(); i++) {
			Stock stock = new Stock();
			System.out.print("\n*************************************************************");
			jsonObject2 = (JSONObject) jsonArray2.get(i);
			System.out.print("\nName : " + jsonObject2.get("name"));
			stock.setName((String) jsonObject2.get("name"));
			System.out.print(" | Shares : " + jsonObject2.get("shares"));
			stock.setShares(((Long) jsonObject2.get("shares")).intValue());
			System.out.print(" | Price : Rs." + jsonObject2.get("price"));
			stock.setPrice(((Double) jsonObject2.get("price")).floatValue());
			stockList.add(stock);
			System.out.print("\n*************************************************************");
		}
		System.out.print("\n  Total Value Of your Stocks        :    Rs." + getTotalStockValue(stockList));
		System.out.print("\n*************************************************************");
	}

	public static float getTotalStockValue(List<Stock> stockList) {
		float totalValue = 0;
		for (Stock stock : stockList) {
			totalValue = totalValue + stock.getValue();
		}
		return totalValue;
	}

}
