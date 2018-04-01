package com.bridgelab.designpattern.behavioraldesignpatterns;

public class Book implements ItemElement{

	private int price;
	private String isbnNumber;
	
	public Book(int price,String isbnNumber){
		this.price = price;
		this.isbnNumber = isbnNumber;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String getIsbnNumber(){
		return isbnNumber;
	}
	
	@Override
	public int accept(ShoppingCartVisitor shoppingCartVisitor) {
		return shoppingCartVisitor.visit(this);
	}

}
