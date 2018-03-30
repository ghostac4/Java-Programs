/**
 * Purpose : Implementation of Eager Initialization Singleton
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
package com.bridgelab.designpattern.creationaldesignpatterns;

public class EagerInitializationSingletonTest {

	public static void main(String[] args) {
		EagerInitializationSingleton eagerInitializationSingleton1 = EagerInitializationSingleton.getInstance();
		
		EagerInitializationSingleton eagerInitializationSingleton2 = EagerInitializationSingleton.getInstance();
		
		if(eagerInitializationSingleton1.hashCode() == eagerInitializationSingleton2.hashCode())
			System.out.print("\nSimilar instance");
		else
			System.out.print("\nDifferent Instance");
	}

}
