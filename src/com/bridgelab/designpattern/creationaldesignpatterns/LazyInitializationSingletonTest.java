package com.bridgelab.designpattern.creationaldesignpatterns;

/**
 * Purpose : Implementation of Lazy Initialization Singleton 
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
public class LazyInitializationSingletonTest {

	public static void main(String[] args) {
		LazyInitializationSingleton lazyInitializationSingleton1 = LazyInitializationSingleton.getInstance();
		
		LazyInitializationSingleton lazyInitializationSingleton2 = LazyInitializationSingleton.getInstance();
		
		if(lazyInitializationSingleton1.hashCode() == lazyInitializationSingleton2.hashCode())
			System.out.print("\nSimilar Instance");
		else
			System.out.print("\nDifferent Instance");
	}

}
