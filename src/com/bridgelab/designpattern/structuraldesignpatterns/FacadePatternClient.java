/**
 * Purpose : Implementation of Facade Design Pattern
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
package com.bridgelab.designpattern.structuraldesignpatterns;

import com.bridgelab.utility.Utility;

public class FacadePatternClient {

	public static void main(String[] args) {
		Utility utility =new Utility();
		int choice;
		do{
			System.out.print("\n                  : 1.Iphone");
			System.out.print("\n                  : 2.Samsung");
			System.out.print("\n                  : 3.Motorola");
			System.out.print("\nEnter your Choice : ");
			choice = utility.readInt();
			ShopKeeper shopKeeper = new ShopKeeper();
			switch(choice){
			case 1 :
				shopKeeper.iPhoneSale();
				break;
			case 2 :
				shopKeeper.samsungSale();
				break;
			case 3 :
				shopKeeper.motorolaSale();
				break;
			default :
				System.out.print("\nNothing is purchased!");
			}
		}while(choice != 4);
	}

}
