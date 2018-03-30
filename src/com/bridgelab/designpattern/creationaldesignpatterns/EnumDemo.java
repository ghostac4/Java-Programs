
/**
 * Purpose : Implementation of Enum Singleton
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */

package com.bridgelab.designpattern.creationaldesignpatterns;

public class EnumDemo {

	public static void main(String[] args) {
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		
		EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
		
		if(enumSingleton.hashCode() == enumSingleton2.hashCode())
			System.out.print("\nSimilar instance");
		else
			System.out.print("\nDifferent instance");
	}

}
