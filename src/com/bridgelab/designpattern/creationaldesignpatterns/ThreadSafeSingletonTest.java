package com.bridgelab.designpattern.creationaldesignpatterns;

/**
 * Purpose : Implementation of Thread Safe Singleton
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
public class ThreadSafeSingletonTest {

	public static void main(String[] args) {
		ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getIntance();
		
		ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getIntance();
		
		if(threadSafeSingleton1.hashCode() == threadSafeSingleton2.hashCode())
			System.out.print("\nSimilar instance");
		else
			System.out.print("\nDifferent instance");
	}

}
