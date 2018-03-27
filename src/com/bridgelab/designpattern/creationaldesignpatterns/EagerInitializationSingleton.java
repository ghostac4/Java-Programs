package com.bridgelab.designpattern.creationaldesignpatterns;

public class EagerInitializationSingleton {

	private static final EagerInitializationSingleton EAGER_INITIALIZATION_SINGLETON =
			new EagerInitializationSingleton();
	
	private EagerInitializationSingleton(){}
	
	public static EagerInitializationSingleton getInstance(){
		return EAGER_INITIALIZATION_SINGLETON;
	}
}
