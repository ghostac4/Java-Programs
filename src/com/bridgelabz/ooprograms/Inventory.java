package com.bridgelab.ooprograms;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Inventory {
	
	private String name;
	private int weight;
	private float price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getValue(){
		return weight*price;
	}

	@SuppressWarnings("unchecked")
	public String getJSONString(){
		JSONObject jsonObject = new JSONObject();	
		jsonObject.put("name",name);
		jsonObject.put("weight", weight);
		jsonObject.put("price", price);
		return JSONValue.toJSONString(jsonObject);
	}
}
