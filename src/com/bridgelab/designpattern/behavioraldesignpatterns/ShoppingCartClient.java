/**
 * Purpose : Implementation of Visitor Design Pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
package com.bridgelab.designpattern.behavioraldesignpatterns;

public class ShoppingCartClient {

	public static void main(String[] args) {

		ItemElement[] itemElements = {new Book(20, "1234"),new Book(100, "5678"),
				new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple")};
		
		int total = calculatePrice(itemElements);
		
		System.out.print("\nTotal Cost : "+total);
	}
	
	/**
	 * function to calculate price for each element
	 * @param itemElements is are array of ItemElement
	 * @return number total price of ItemElements
	 */
	public static int calculatePrice(ItemElement[] itemElements){
		ShoppingCartVisitorimpl shoppingCartVisitorimpl = new ShoppingCartVisitorimpl();
		int sum=0;
		for(ItemElement itemElement : itemElements){
			sum = sum + itemElement.accept(shoppingCartVisitorimpl);
		}
		return sum;
	}

}
