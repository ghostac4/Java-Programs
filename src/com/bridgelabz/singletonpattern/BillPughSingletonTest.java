
/**
 * Purpose : Implementation of Bill Singleton pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */

package com.bridgelab.designpattern.creationaldesignpatterns;

public class BillPughSingletonTest {

	public static void main(String[] args) {
		BillPughSingleton billPughSingleton1 = BillPughSingleton.getInstance();
		
		BillPughSingleton billPughSingleton2 = BillPughSingleton.getInstance();
		
		if(billPughSingleton1.hashCode() == billPughSingleton2.hashCode())
			System.out.print("\nSimilar objects");
		else
			System.out.print("\nDifferent Objects");
	}

}
